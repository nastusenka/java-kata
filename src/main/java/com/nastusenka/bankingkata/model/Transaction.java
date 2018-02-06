package com.nastusenka.bankingkata.model;

import java.time.LocalDateTime;

public abstract class Transaction {

    private int balance;
    protected int amount;
    private LocalDateTime date;

    public Transaction(int balance, int amount, LocalDateTime date) {
        this.balance = balance;
        this.amount = amount;
        this.date = date;
    }

    public int getBalance() {
        return balance;
    }

    public abstract int getAmount();

    public LocalDateTime getDate() {
        return date;
    }
}
