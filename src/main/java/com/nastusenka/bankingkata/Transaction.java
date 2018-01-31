package com.nastusenka.bankingkata;

import java.time.LocalDateTime;

public class Transaction {

    private int balance;
    private int amount;
    private LocalDateTime date;

    public Transaction(int balance, int amount, LocalDateTime date) {
        this.balance = balance;
        this.amount = amount;
        this.date = date;
    }

    public int getBalance() {
        return balance;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
