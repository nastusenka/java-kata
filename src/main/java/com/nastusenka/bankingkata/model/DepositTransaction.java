package com.nastusenka.bankingkata.model;

import java.time.LocalDateTime;

public class DepositTransaction extends Transaction {

    public DepositTransaction(int balance, int amount, LocalDateTime date) {
        super(balance, amount, date);
    }

    @Override
    public int getAmount() {
        return amount;
    }
}
