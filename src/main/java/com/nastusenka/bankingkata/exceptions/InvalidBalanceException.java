package com.nastusenka.bankingkata.exceptions;

public class InvalidBalanceException extends Exception {
    public InvalidBalanceException() {
    }

    public InvalidBalanceException(String message) {
        super(message);
    }
}
