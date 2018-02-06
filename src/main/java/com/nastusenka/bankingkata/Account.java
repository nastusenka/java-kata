package com.nastusenka.bankingkata;

import com.nastusenka.bankingkata.exceptions.InvalidBalanceException;
import com.nastusenka.bankingkata.model.DepositTransaction;
import com.nastusenka.bankingkata.model.Transaction;
import com.nastusenka.bankingkata.model.WithdrawalTransaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private int balance;
    private List<Transaction> transactions = new ArrayList<>();

    /**
     * Constructor with parameters validation
     *
     * @param balance Initial amount for account creation
     * @throws InvalidBalanceException when the balance is below zero
     */
    public Account(int balance) throws InvalidBalanceException {
        if (balance < 0) {
            throw new InvalidBalanceException("Initial balance should be positive");
        }
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    /**
     * Replenish account and save transaction
     *
     * @param amount Amount to deposit
     */
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount should be positive");
        }
        balance += amount;
        Transaction transaction = new DepositTransaction(balance, amount, LocalDateTime.now());
        transactions.add(transaction);
    }

    /**
     * Withdraw from account and save transaction
     *
     * @param amount Amount to withdraw
     * @throws InvalidBalanceException when the balance is below zero
     * @throws IllegalArgumentException when the parameter is below zero
     */
    public void withdraw(int amount) throws InvalidBalanceException, IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount should be positive");
        }
        if (amount > balance) {
            throw new InvalidBalanceException("Can not withdraw the amount provided, balance will become negative");
        }
        balance = balance - amount;
        Transaction transaction = new WithdrawalTransaction(balance, amount, LocalDateTime.now());
        transactions.add(transaction);
    }

    /**
     * Print saved transactions
     *
     * @return Formated statement
     */
    public String printStatement() {
        String output = String.format("|%20s|%20s|%20s|%n", "DATE", "AMOUNT", "BALANCE");
        for (Transaction transaction : transactions) {
            output = output + String.format(
                    "|%20s|%20d|%20d|%n",
                    transaction.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    transaction.getAmount(),
                    transaction.getBalance()
            );
        }
        return output;
    }
}
