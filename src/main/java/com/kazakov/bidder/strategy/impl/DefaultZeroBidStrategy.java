package com.kazakov.bidder.strategy.impl;

import com.kazakov.bidder.strategy.BidStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of a default zero strategy.
 * Makes 0 as a bid.
 */
public class DefaultZeroBidStrategy implements BidStrategy {

    private static final Logger log = LoggerFactory.getLogger(DefaultZeroBidStrategy.class);

    @Override
    public int getBidAmount() {
        log.info("Chosen default zero strategy. Bid amount: 0");
        return 0;
    }
}
