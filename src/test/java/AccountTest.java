import com.nastusenka.bankingkata.Account;
import com.nastusenka.bankingkata.exceptions.InvalidBalanceException;
import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test(expected = InvalidBalanceException.class)
    public void testInputBalanceWrong() throws InvalidBalanceException {
        new Account(-1);
    }

    @Test
    public void testDeposit() throws InvalidBalanceException {
        Account account = new Account(50);
        account.deposit(500);
        Assert.assertEquals(550, account.getAccountBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositBelowZero() throws IllegalArgumentException, InvalidBalanceException {
        new Account(50).deposit(-1);
    }
}
