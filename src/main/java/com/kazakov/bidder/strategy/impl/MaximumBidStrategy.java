package com.kazakov.bidder.strategy.impl;

import com.kazakov.bidder.strategy.BidStrategy;

/**
 * Implementation of the maximum strategy.
 * Sets the maximum bid. For example, if there is only one iteration
 */
public class MaximumBidStrategy implements BidStrategy {

    private final int monetaryUnits;

    public MaximumBidStrategy(int monetaryUnits) {
        this.monetaryUnits = monetaryUnits;
    }

    @Override
    public int getBidAmount() {
        return monetaryUnits;
    }
}
