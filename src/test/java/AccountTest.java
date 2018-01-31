import com.nastusenka.bankingkata.Account;
import com.nastusenka.bankingkata.exceptions.InvalidBalanceException;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccountTest {

    @Test(expected = InvalidBalanceException.class)
    public void testInputBalanceWrong() throws InvalidBalanceException {
        new Account(-1);
    }

    @Test
    public void testDeposit() throws InvalidBalanceException {
        Account account = new Account(50);
        account.deposit(500);
        Assert.assertEquals(550, account.getBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositBelowZero() throws IllegalArgumentException, InvalidBalanceException {
        new Account(50).deposit(-1);
    }

    @Test
    public void testWithdraw() throws InvalidBalanceException{
        Account account = new Account(100);
        account.withdraw(50);
        Assert.assertEquals(50,account.getBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawBelowZero() throws IllegalArgumentException, InvalidBalanceException {
        new Account(50).withdraw(-1);
    }

    @Test(expected = InvalidBalanceException.class)
    public void testWithdrawBalanceBelowZero() throws InvalidBalanceException {
        new Account(50).withdraw(100);
    }

    @Test
    public void testPrintStatement() throws InvalidBalanceException {
        LocalDateTime dateTime = LocalDateTime.now();
        int depositAmount = 500;
        int withdrawAmount = 200;
        String expectedOutput = String.format(
                "|%20s|%20s|%20s|%n|%20s|%20d|%20d|%n|%4$20s|%20d|%20d|%n",
                "DATE", "AMOUNT", "BALANCE",
                dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                depositAmount,
                depositAmount,
                -withdrawAmount,
                300);

        Account account = new Account(0);
        account.deposit(depositAmount);
        account.withdraw(withdrawAmount);

        Assert.assertEquals(expectedOutput, account.printStatement());
    }
}
