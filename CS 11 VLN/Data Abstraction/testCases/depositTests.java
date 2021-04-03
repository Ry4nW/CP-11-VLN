import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import static org.junit.Assert.assertEquals;

public class depositTests {
    Customer janeDoe;
    Date date = new Date();

    @Before
    public void setup() {
        janeDoe = new Customer("Jane Doe", 69, 420);
    }

    @Test
    public void checkingTest() {
        assertEquals(0, janeDoe.getDepositsLength());
        janeDoe.deposit(100, date, "chEckInG");
        assertEquals(169, janeDoe.getCheckBalance(), 0.0);
        assertEquals(1, janeDoe.getDepositsLength());
        assertEquals(("[Deposit of: 100.0 | Date: " + date + " | Into account: Checking]").toLowerCase(), janeDoe.getDeposits().toString().toLowerCase());
    }

    @Test
    public void savingTest() {
        assertEquals(0, janeDoe.getDepositsLength());
        janeDoe.deposit(200.51, date, "sAvINg");
        assertEquals(620.51, janeDoe.getSavingBalance(), 0.0);
        assertEquals(1, janeDoe.getDepositsLength());
        assertEquals(("[Deposit of: 200.51 | Date: " + date + " | Into account: Saving]").toLowerCase(), janeDoe.getDeposits().toString().toLowerCase());
    }

    @Test
    public void invalidTest() {
        assertEquals(-1, janeDoe.deposit(200, date, "this is not a valid account type"), 0.0);
        assertEquals(0, janeDoe.getDepositsLength());
    }

}
