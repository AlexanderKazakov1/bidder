package com.kazakov.bidder.model;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Bidder's model
 * Contains data about the auction participant
 */
public class Participant {

    /**
     * Money spent during each iteration
     */
    private final Deque<Integer> spentCash = new LinkedList<>();

    /**
     * The rest of money
     */
    private int moneyBalance;

    /**
     * QU that bidder won
     */
    private int quantityUnits;

    public Integer getLastSpentCash() {
        return this.spentCash.getLast();
    }

    public void addToSpentCash(int cash) {
        this.spentCash.add(cash);
    }

    public int getMoneyBalance() {
        return moneyBalance;
    }

    public void setMoneyBalance(int moneyBalance) {
        this.moneyBalance = moneyBalance;
    }

    public int getQuantityUnits() {
        return quantityUnits;
    }

    public void setQuantityUnits(int own, int other) {
        if (own > other) {
            this.quantityUnits += 2;
        } else if (own == other) {
            this.quantityUnits += 1;
        }
    }
}
