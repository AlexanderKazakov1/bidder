package com.kazakov.bidder.strategy;

/**
 * Bid selection strategy
 */
public interface BidStrategy {

    /**
     * Calculates a bid amount based on the selected strategy
     *
     * @return a bid amount
     */
    int getBidAmount();
}
