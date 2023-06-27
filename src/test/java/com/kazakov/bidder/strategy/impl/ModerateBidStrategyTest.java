package com.kazakov.bidder.strategy.impl;

import com.kazakov.bidder.strategy.BidStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModerateBidStrategyTest {

    @Test
    public void when_600_moneyBalance_and_6_quantityUnits_then_return_100_bid() {
        int moneyBalance = 600;
        int quantityUnits = 6;
        BidStrategy strategy = new ModerateBidStrategy(moneyBalance, quantityUnits);

        int expected = 100;

        int actual = strategy.getBidAmount();

        assertEquals(expected, actual);
    }

    @Test
    public void when_100_moneyBalance_and_6_quantityUnits_then_return_16_bid() {
        int moneyBalance = 100;
        int quantityUnits = 6;
        BidStrategy strategy = new ModerateBidStrategy(moneyBalance, quantityUnits);

        int expected = 16;

        int actual = strategy.getBidAmount();

        assertEquals(expected, actual);
    }

}