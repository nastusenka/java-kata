package com.nastusenka.bankingkata;

import com.nastusenka.bankingkata.exceptions.InvalidBalanceException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private int accountBalance;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(int accountBalance) throws InvalidBalanceException {
        if (accountBalance < 0) throw new InvalidBalanceException();
        this.accountBalance = accountBalance;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void deposit(int accountAmount) {
        if (accountAmount < 0) { throw new IllegalArgumentException("The parameter cann't be below zero");}
        accountBalance = accountBalance + accountAmount;
        LocalDateTime dateTime = null;
        Transaction transaction = new Transaction(accountBalance, accountAmount, dateTime.now());
        transactions.add(transaction);
    }
}
