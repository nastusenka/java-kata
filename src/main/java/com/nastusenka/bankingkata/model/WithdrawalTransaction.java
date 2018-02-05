package com.nastusenka.bankingkata.model;

import java.time.LocalDateTime;

public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction(int balance, int amount, LocalDateTime date) {
        super(balance, amount, date);
    }

    @Override
    public int getAmount() {
        return -amount;
    }
}
