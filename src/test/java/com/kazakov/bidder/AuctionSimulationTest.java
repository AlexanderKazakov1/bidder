package com.kazakov.bidder;

import com.kazakov.bidder.impl.BidderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class AuctionSimulationTest {

    private Bidder me;
    private Bidder opponent;

    @BeforeEach
    public void before() {
        this.me = new BidderImpl();
        this.opponent = mock(Bidder.class);

        doNothing().when(opponent).init(anyInt(), anyInt());
        doNothing().when(opponent).bids(anyInt(), anyInt());
    }

    @Test
    public void when_200_opponentBid_10_quantity_1000_cash_then_I_Won() {
        doReturn(200).when(opponent).placeBid();

        int opponentWinNumber = 0;
        int myWinNumber = 0;

        int quantity = 10;
        int cash = 1000;

        me.init(quantity, cash);
        opponent.init(quantity, cash);

        for (int i = 0; i < quantity; i += 2) {
            int myBid = me.placeBid();
            int opponentBid = opponent.placeBid();

            me.bids(myBid, opponentBid);
            opponent.bids(opponentBid, myBid);

            if (myBid > opponentBid) myWinNumber++;
            else opponentWinNumber++;
        }

        assertTrue(myWinNumber > opponentWinNumber);
    }

    @Test
    public void when_1200_opponentBid_30_quantity_20000_cash_then_I_Won() {
        int opponentWinNumber = 0;
        int myWinNumber = 0;

        int quantity = 30;
        int cash = 20000;

        doReturn(1200).when(opponent).placeBid();

        me.init(quantity, cash);
        opponent.init(quantity, cash);

        for (int i = 0; i < quantity; i += 2) {
            int myBid = me.placeBid();
            int opponentBid = opponent.placeBid();

            me.bids(myBid, opponentBid);
            opponent.bids(opponentBid, myBid);

            if (myBid > opponentBid) myWinNumber++;
            else opponentWinNumber++;
        }

        assertTrue(myWinNumber > opponentWinNumber);
    }

    @Test
    public void when_200_opponentBid_increasing_with_step_100_10_quantity_1000_cash_then_I_Won() {
        int opponentWinNumber = 0;
        int myWinNumber = 0;

        int quantity = 10;
        int cash = 1000;

        me.init(quantity, cash);
        opponent.init(quantity, cash);

        int mockOpponentBid = 200;
        doReturn(mockOpponentBid).when(opponent).placeBid();

        int opponentCashBalance = cash;
        for (int i = 0; i < quantity; i += 2) {
            int myBid = me.placeBid();
            int opponentBid = opponent.placeBid();

            me.bids(myBid, opponentBid);
            opponent.bids(opponentBid, myBid);

            opponentCashBalance -= mockOpponentBid;

            if (myBid > opponentBid) myWinNumber++;
            else opponentWinNumber++;

            if (opponentCashBalance > 0 && opponentCashBalance > opponentBid) {
                mockOpponentBid+=100;
                doReturn(mockOpponentBid).when(opponent).placeBid();
            } else {
                mockOpponentBid = 0;
                opponentCashBalance = 0;
                doReturn(mockOpponentBid).when(opponent).placeBid();
            }
        }

        assertTrue(myWinNumber > opponentWinNumber);
    }

    @Test
    public void when_300_opponentBid_decreasing_with_step_100_10_quantity_1000_cash_then_I_Won() {
        int opponentWinNumber = 0;
        int myWinNumber = 0;

        int quantity = 10;
        int cash = 1000;

        me.init(quantity, cash);
        opponent.init(quantity, cash);

        int mockOpponentBid = 300;
        doReturn(mockOpponentBid).when(opponent).placeBid();

        for (int i = 0; i < quantity; i += 2) {
            int myBid = me.placeBid();
            int opponentBid = opponent.placeBid();

            me.bids(myBid, opponentBid);
            opponent.bids(opponentBid, myBid);

            if (myBid > opponentBid) myWinNumber++;
            else opponentWinNumber++;

            mockOpponentBid-=50;
            doReturn(mockOpponentBid).when(opponent).placeBid();
        }

        assertTrue(myWinNumber > opponentWinNumber);
    }

}
