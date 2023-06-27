package com.kazakov.bidder.impl;

import com.kazakov.bidder.Bidder;
import com.kazakov.bidder.model.Participant;
import com.kazakov.bidder.strategy.BidStrategy;
import com.kazakov.bidder.strategy.impl.AggressiveBidStrategy;
import com.kazakov.bidder.strategy.impl.DefaultZeroBidStrategy;
import com.kazakov.bidder.strategy.impl.ModerateBidStrategy;
import com.kazakov.bidder.strategy.impl.MaximumBidStrategy;
import com.kazakov.bidder.strategy.impl.SurvivalBidStrategy;

/**
 * Waiting implementation of {@link Bidder} based on the opponent's cash spent.
 * It waits for the opponent's first bet and, based on it, forms a strategy for choosing a bet.
 * The strategy may change every iteration.
 */
public class BidderImpl implements Bidder {

    private Participant opponent;
    private Participant me;
    private int quantityUnits;
    private int monetaryUnits;
    private int iteration;

    public void init(int quantity, int cash) {
        me = new Participant();
        opponent = new Participant();
        quantityUnits = quantity;
        monetaryUnits = cash;
        iteration = 1;
    }

    public int placeBid() {
        BidStrategy strategy = chooseStrategy();
        int bid = strategy.getBidAmount();
        return bid > me.getMoneyBalance() ? 0 : bid;
    }

    public void bids(int own, int other) {
        me.setMoneyBalance(iteration == 1 ? monetaryUnits - own : me.getMoneyBalance() - own);
        me.setQuantityUnits(own, other);
        me.addToSpentCash(own);

        opponent.setMoneyBalance(iteration == 1 ? monetaryUnits - other : opponent.getMoneyBalance() - other);
        opponent.setQuantityUnits(other, own);
        opponent.addToSpentCash(other);

        quantityUnits -= 2;
        iteration++;
    }

    private BidStrategy chooseStrategy() {
        if (iteration == 1) {
            if (quantityUnits == 2) {
                return new MaximumBidStrategy(monetaryUnits);
            }
            return new DefaultZeroBidStrategy();
        }
        if (opponent.getLastSpentCash() > 0) {
            if (iteration == 2 || isKeepWinning()) {
                return new AggressiveBidStrategy(opponent.getLastSpentCash());
            }
        }
        if (!isKeepWinning() && hasOpponentTwiceAsMuchBalance()) {
            return new SurvivalBidStrategy(opponent.getMoneyBalance());
        }
        return new ModerateBidStrategy(me.getMoneyBalance(), quantityUnits);
    }

    private boolean hasOpponentTwiceAsMuchBalance() {
        return opponent.getMoneyBalance() * 2 > me.getMoneyBalance();
    }

    private boolean isKeepWinning() {
        return me.getQuantityUnits() >= opponent.getQuantityUnits();
    }

}
