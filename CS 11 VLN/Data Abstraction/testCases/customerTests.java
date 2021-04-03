import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class customerTests {
    Customer customer;
    Customer johnDoe;

    @Before
    public void setup() {
        customer = new Customer();
        johnDoe = new Customer("John Doe", 69, 420);
    }

    @Test
    public void testDefaultFields() {
        assertTrue((customer.getAccountNumber() >= 1000000) && (customer.getAccountNumber() <= 9000000));
        assertEquals(100, customer.getCheckBalance(), 0.0);
        assertEquals(100, customer.getSavingBalance(), 0.0);
        assertEquals(0.1, customer.getSavingRate(), 0.0);
        assertEquals("Demo", customer.getName());
    }

    @Test
    public void testNonDefaultFields() {
        assertEquals("John Doe", "John Doe", johnDoe.getName());
        assertEquals(69, johnDoe.getCheckBalance(), 0.0);
        assertEquals(420, johnDoe.getSavingBalance(), 0.0);
        assertTrue((johnDoe.getAccountNumber() >= 1000000) && (johnDoe.getAccountNumber() <= 9000000));
    }

}