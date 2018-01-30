package com.nastusenka.bankingkata;

import com.nastusenka.bankingkata.exceptions.InvalidBalanceException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private int accountBalance;
    private List<Transaction> transactions = new ArrayList<>();

    /**
     * Constructor with parameters validation
     *
     * @param accountBalance Initial amount for account creation
     * @throws InvalidBalanceException when the balance is below zero
     */
    public Account(int accountBalance) throws InvalidBalanceException {
        if (accountBalance < 0) throw new InvalidBalanceException();
        this.accountBalance = accountBalance;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    /**
     * Replenish account and save transaction
     *
     * @param accountAmount Amount to deposit
     */
    public void deposit(int accountAmount) {
        if (accountAmount < 0) { throw new IllegalArgumentException("The parameter can't be below zero");}
        accountBalance = accountBalance + accountAmount;
        LocalDateTime dateTime = null;
        Transaction transaction = new Transaction(accountBalance, accountAmount, dateTime.now());
        transactions.add(transaction);
    }

    /**
     * Withdraw from account and save transaction
     *
     * @param accountAmount Amount to withdraw
     * @throws InvalidBalanceException when the balance is below zero
     * @throws IllegalArgumentException when the parameter is below zero
     */
    public void withdraw(int accountAmount) throws InvalidBalanceException, IllegalArgumentException {
        if (accountAmount < 0) { throw new IllegalArgumentException("The parameter can't be below zero");}
        if (accountAmount > accountBalance) {
            throw new InvalidBalanceException();
        }
        accountBalance = accountBalance - accountAmount;
        LocalDateTime dateTime = null;
        Transaction transaction = new Transaction(accountBalance, -accountAmount, dateTime.now());
        transactions.add(transaction);
    }

    /**
     * Print saved transactions
     *
     * @return Formated statement
     */
    public String printStatement() {
        String output = String.format("|%20s|%20s|%20s|%n", "DATE", "AMOUNT", "BALANCE");
        for (Transaction temp : transactions) {
            output = output + String.format(
                    "|%20s|%20d|%20d|%n",
                    temp.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    temp.getAmount(),
                    temp.getBalance()
            );
        }
        return output;
    }
}
