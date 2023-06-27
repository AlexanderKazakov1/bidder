package com.kazakov.bidder.strategy.impl;

import com.kazakov.bidder.strategy.BidStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultZeroBidStrategyTest {

    @Test
    public void when_using_default_bidder_then_return_0_bid() {
        BidStrategy strategy = new DefaultZeroBidStrategy();

        int expected = 0;

        int actual = strategy.getBidAmount();

        assertEquals(expected, actual);
    }

}