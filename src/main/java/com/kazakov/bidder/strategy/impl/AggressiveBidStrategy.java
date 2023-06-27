package com.kazakov.bidder.strategy.impl;

import com.kazakov.bidder.strategy.BidStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of an aggressive strategy.
 * Forms a bet based on the opponent's early spent money.
 */
public class AggressiveBidStrategy implements BidStrategy {

    private static final Logger log = LoggerFactory.getLogger(AggressiveBidStrategy.class);
    private final int opponentSpentCash;

    public AggressiveBidStrategy(int opponentSpentCash) {
        this.opponentSpentCash = opponentSpentCash;
    }

    @Override
    public int getBidAmount() {
        int result = opponentSpentCash + opponentSpentCash * 20 / 100;
        log.info("Chosen aggressive strategy. Last opponent cash spent: {}, bid amount: {}", opponentSpentCash, result);
        return result;
    }
}
