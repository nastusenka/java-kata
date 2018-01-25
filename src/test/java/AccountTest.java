import com.nastusenka.bankingkata.Account;
import com.nastusenka.bankingkata.exceptions.InvalidBalanceException;
import org.junit.Test;

public class AccountTest {

    @Test(expected = InvalidBalanceException.class)
    public void testInputBalanceWrong() throws InvalidBalanceException {
        new Account(-1);
    }
}
