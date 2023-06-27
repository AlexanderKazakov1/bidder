package com.kazakov.bidder.strategy.impl;

import com.kazakov.bidder.strategy.BidStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of a moderate strategy.
 * Places a bet based on the division of the remaining amount of money by quantity units.
 */
public class ModerateBidStrategy implements BidStrategy {

    private static final Logger log = LoggerFactory.getLogger(ModerateBidStrategy.class);
    private final int quantityUnits;
    private final int myMoneyBalance;

    public ModerateBidStrategy(int myMoneyBalance, int quantityUnits) {
        this.myMoneyBalance = myMoneyBalance;
        this.quantityUnits = quantityUnits;
    }

    @Override
    public int getBidAmount() {
        int result = myMoneyBalance / quantityUnits;
        log.info("Chosen equitable strategy. My money balance: {}, quantity units: {}, bid amount: {}",
                myMoneyBalance, quantityUnits, result);
        return result;
    }
}
