package com.kazakov.bidder.strategy.impl;

import com.kazakov.bidder.strategy.BidStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumBidStrategyTest {

    @Test
    public void when_1000_monetaryUnits_then_return_1000_bid() {
        int monetaryUnits = 1000;
        BidStrategy strategy = new MaximumBidStrategy(monetaryUnits);

        int expected = 1000;

        int actual = strategy.getBidAmount();

        assertEquals(expected, actual);
    }
}