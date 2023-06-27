package com.kazakov.bidder.strategy.impl;

import com.kazakov.bidder.strategy.BidStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SurvivalBidStrategyTest {

    @Test
    public void when_500_monetaryUnits_then_return_501_bid() {
        int moneyBalance = 500;
        BidStrategy strategy = new SurvivalBidStrategy(moneyBalance);

        int expected = 501;

        int actual = strategy.getBidAmount();

        assertEquals(expected, actual);
    }

}