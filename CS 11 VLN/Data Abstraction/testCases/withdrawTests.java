import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class withdrawTests {
    Date date = new Date();
    Customer edwardDoe;

    @Before
    public void setup() {
        edwardDoe = new Customer("Edward Doe", 69, 420);
    }

    @Test
    public void checkingTest() {
        assertEquals(0, edwardDoe.getWithdrawalsLength());
        edwardDoe.withdraw(edwardDoe, 69, date, "cHeCkiNG");
        assertEquals(0, edwardDoe.getCheckBalance(), 0.0);
        assertEquals(1, edwardDoe.getWithdrawalsLength());
        assertEquals(("[Withdrawal of: 69.0 | Date: " + date + " | From account: checking]").toLowerCase(), edwardDoe.getWithdraws().toString().toLowerCase());
    }

    @Test
    public void checkingOverdraftTest() {
        assertEquals(0, edwardDoe.getWithdrawalsLength());
        assertEquals(69, edwardDoe.withdraw(edwardDoe, 70, date, "checking"), 0.0);
        assertEquals(0, edwardDoe.getWithdrawalsLength());
    }

    @Test
    public void savingTest() {
        assertEquals(0, edwardDoe.getWithdrawalsLength());
        edwardDoe.withdraw(edwardDoe, 420, date, "sAvInG");
        assertEquals(0, edwardDoe.getSavingBalance(), 0.0);
        assertEquals(1, edwardDoe.getWithdrawalsLength());
        assertEquals(("[Withdrawal of: 420.0 | Date: " + date + " | From account: Saving]").toLowerCase(), edwardDoe.getWithdraws().toString().toLowerCase());
    }

    @Test
    public void savingOverdraftTest() {
        assertEquals(0, edwardDoe.getWithdrawalsLength());
        assertEquals(420, edwardDoe.withdraw(edwardDoe, 421, date, "saving"), 0.0);
        assertEquals(0, edwardDoe.getWithdrawalsLength());
    }

    @Test
    public void invalidTest() {
        assertEquals(-1, edwardDoe.withdraw(edwardDoe,200, date, "this is not a valid account type"), 0.0);
    }
}
