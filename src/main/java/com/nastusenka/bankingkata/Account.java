package com.nastusenka.bankingkata;

import com.nastusenka.bankingkata.exceptions.InvalidBalanceException;

public class Account {

    private int accountBalance;

    public Account(int accountBalance) throws InvalidBalanceException {
        if (accountBalance < 0) throw new InvalidBalanceException();
        this.accountBalance = accountBalance;
    }
}
