package com.kazakov.bidder.strategy.impl;

import com.kazakov.bidder.strategy.BidStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of survival strategy.
 * Places a bet based on the opponent's balance.
 */
public class SurvivalBidStrategy implements BidStrategy {

    private static final Logger log = LoggerFactory.getLogger(SurvivalBidStrategy.class);
    private final int opponentMoneyBalance;

    public SurvivalBidStrategy(int opponentMoneyBalance) {
        this.opponentMoneyBalance = opponentMoneyBalance;
    }

    @Override
    public int getBidAmount() {
        int result = opponentMoneyBalance + 1;
        log.info("Chosen survivor strategy. Opponent's money balance: {}, bid amount: {}", opponentMoneyBalance, result);
        return result;
    }
}
