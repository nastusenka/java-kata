import com.nastusenka.bankingkata.model.DepositTransaction;
import com.nastusenka.bankingkata.model.WithdrawalTransaction;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class TransactionTest {

    @Test
    public void testWithdrawalTransaction() {
        Assert.assertEquals(
                -50,
                new WithdrawalTransaction(100, 50, LocalDateTime.now()).getAmount( ));
    }

    @Test
    public void testDepositTransaction() {
        Assert.assertEquals(
                50,
                new DepositTransaction(100, 50, LocalDateTime.now()).getAmount( ));
    }

}
