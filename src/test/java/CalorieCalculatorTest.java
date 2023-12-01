import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.team1.CalorieCalculator.CalorieCalculator;
import org.team1.CalorieCalculator.ConversionUtil;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalorieCalculatorTest {

    private ConversionUtil util;
    private CalorieCalculator calculator;

    @BeforeEach
    void setUp() {
        this.calculator= new CalorieCalculator();
    }

    @AfterEach
    void tearDown() {
    }


    /**
     * A test to make sure getPurchaseCount counts the correct total purchase
     *  to the register
     */

//    @Test
//    @DisplayName("getPurchaseCount() - test for correct purchase count")
//    void getTotalCalories() {
//        int result = register.getPurchaseCount();
//        //A new register should have no purchases
//        assertEquals(0, result);
//
//        //Purchase two items, and verify it to be correct
//        register.scanItem(0.55);
//        register.scanItem(1.27);
//        assertEquals(2, register.getPurchaseCount());
//    }
//
//    /**
//     * A test to make sure the getListOfPurchase linked list records the correct total prices
//     */
//    @Test
//    @DisplayName("getListOfPurchases() - test for correct purchase list items")
//    void getListOfPurchases() {
//        //Make sure the list is empty
//        assertEquals(0, register.getListOfPurchases().size());
//
//        // Scan 2 items and check the list of purchases
//        register.scanItem(0.55);
//        register.scanItem(1.27);
//        assertEquals(2, register.getListOfPurchases().size());
//        assertEquals("[0.55, 1.27]", register.getListOfPurchases().toString());
//    }
//
//    /**
//     * A test to make sure the correct total of all Transactions is recorded
//     * to the register
//     */
//    @Test
//    @DisplayName("getTransactionTotal()- test for correct transaction total")
//    void getTransactionTotal() {
//        //Make sure the transaction total is 0
//        assertEquals(0.0, register.getTransactionTotal(), FLOAT_DELTA);
//
//        // Scan 2 items and check the transaction total
//        register.scanItem(0.55);
//        register.scanItem(1.27);
//        assertEquals(1.82, register.getTransactionTotal(), FLOAT_DELTA);
//    }
//
////    @Test
////    void getPaymentCollected() {
////    }
//
////    @Test
////    void scanItem() {
////    }
//
//    /**
//     * A test to make sure exceptions are thrown if a bad scan value is passed
//     * to the register, and NOT throw as long as we scan valid items
//     */
//    @Test
//    @DisplayName("scanItem() - exception for bad scan value")
//    void scanItemException() {
//        //Scan for a negative price
//        assertThrows(IllegalArgumentException.class, () -> register.scanItem(-0.5));
//
//        //Scan for a ridiculously large price
//        assertThrows(IllegalArgumentException.class, () -> register.scanItem(-10000.0));
//
//        //Make sure a good scan does NOT throw any exception
//        assertDoesNotThrow(() -> register.scanItem(10.0));
//
//
//    }
//
//    /**
//     * A  test to make sure collectPayment collects the right amount of money from customer
//     */
//    @Test
//    @DisplayName("collectPayment() - test for bad scan value")
//    void collectPayment() {
//        //Make sure the  initial payment collected is 0
//        assertEquals(0, register.getPaymentCollected());
//
//        // enter payment received from customer
//        register.collectPayment(Money.DOLLAR, 1);
//        register.collectPayment(Money.QUARTER, 3);
//        register.collectPayment(Money.NICKEL, 2);
//        assertEquals(1.85, register.getPaymentCollected());
//    }
//
//    /**
//     * A test to make sure exceptions are thrown if a bad collect payment value is passed
//     * to the register
//     *
//     */
//    @Test
//    @DisplayName("collectPaymentException() - test for bad scan value")
//    void collectPaymentException() {
//        // Check for a  0 payment collected
//        assertThrows(IllegalArgumentException.class, () -> register.collectPayment(Money.DOLLAR,0));
//
//        //Check for an exception for a negative payment collected
//        assertThrows(IllegalArgumentException.class, () -> register.collectPayment(Money.QUARTER,-20));
//
//        //Make sure a good scan does not throw any exceptions
//        assertDoesNotThrow(() -> register.collectPayment(Money.NICKEL, 4));
//
//    }
//    /**
//     * A test to make sure give change method works given the payments made
//     *
//     */
//    @Test
//    @DisplayName("giveChange() - test for correct amount of  change given")
//    void giveChange() throws ChangeException {
//        //Make sure the change given is 0
//        assertEquals(0.0, register.giveChange());
//
//        // enter payment received from customer and check change
//        register.scanItem(0.55);
//        register.scanItem(1.27);
//        register.collectPayment(Money.DOLLAR, 1);
//        register.collectPayment(Money.QUARTER, 3);
//        register.collectPayment(Money.NICKEL, 2);
//        assertEquals(0.03, register.giveChange(), FLOAT_DELTA);
//    }
//
//    /**
//     * A test to check if exceptions are thrown when insufficient payment was collected in order to give change
//     */
//    @Test
//    @DisplayName("giveChangeException() - exception for insufficient collect payment")
//    void giveChangeException() {
//        register.scanItem(5.00);
//        register.collectPayment(Money.DOLLAR, 1);
//        assertThrows(ChangeException.class, () -> register.giveChange() );
//    }
//
//    /**
//     * A test to check if simple cash register itself reproduces the same results
//     * using the override
//     */
//    @Test
//    @DisplayName("testEquals()")
//    void testEquals() {
//        this.register2= new SimpleCashRegister();
//        //check if two instances ar equal
//        assertEquals(register, register2);
//        register.scanItem(0.50);
//        register.scanItem(1.00);
//        register.collectPayment(Money.DOLLAR, 1);
//        register.collectPayment(Money.QUARTER, 2);
//
//        //check that two instances are not equal
//        assertNotEquals(register, register2);
//
//        register2.scanItem(0.50);
//        register2.scanItem(1.00);
//        register2.collectPayment(Money.DOLLAR, 1);
//        register2.collectPayment(Money.QUARTER, 2);
//        //check that two instances ar equal
//        assertEquals(register, register2);
//
//    }



}
