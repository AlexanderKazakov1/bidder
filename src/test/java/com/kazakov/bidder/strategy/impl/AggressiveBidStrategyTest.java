package com.kazakov.bidder.strategy.impl;

import com.kazakov.bidder.strategy.BidStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AggressiveBidStrategyTest {

    @Test
    public void when_200_cash_then_return_240_bid() {
        int cash = 200;
        BidStrategy strategy = new AggressiveBidStrategy(cash);

        int expected = 240;

        int actual = strategy.getBidAmount();

        assertEquals(expected, actual);
    }

    @Test
    public void when_1200_cash_then_return_1440_bid() {
        int cash = 1200;
        BidStrategy strategy = new AggressiveBidStrategy(cash);

        int expected = 1440;

        int actual = strategy.getBidAmount();

        assertEquals(expected, actual);
    }

}