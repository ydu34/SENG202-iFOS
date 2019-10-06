package seng202.group5.information;

import org.joda.money.Money;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import seng202.group5.information.DietEnum;
import seng202.group5.information.Ingredient;
import static org.junit.jupiter.api.Assertions.*;

import static org.joda.money.Money.parse;

class CustomerTest {

    Customer customer;
    Money noCash = parse("NZD 0.00");
    Money smallCash = parse("NZD 1.00");
    Money validCash = parse("NZD 10.00");
    Money justUnderCash = parse("NZD 9.99");

    @BeforeEach
    public void init() {
        customer = new Customer();
        customer.setPurchasePoints(10);

    }

    @Test
    public void testAddPurchasePointsSmallPurchase() {
        customer.purchasePoints(smallCash);
        assertEquals(10, customer.getPurchasePoints());
    }

    @Test
    public void testAddPurchasePointsNoPurchase() {
        customer.purchasePoints(noCash);
        assertEquals(10, customer.getPurchasePoints());
    }

    @Test
    public void testAddPurchasePointsJustUnderPurchase() {
        customer.purchasePoints(justUnderCash);
        assertEquals(10, customer.getPurchasePoints());
    }

    @Test
    public void testAddPurchasePointsOnePoint() {
        customer.purchasePoints(validCash);
        assertEquals(11, customer.getPurchasePoints());
    }

    @Test
    public void testAddPurchasePointsOnePointJustUnder() {
        customer.purchasePoints(justUnderCash.plus(validCash));
        assertEquals(11, customer.getPurchasePoints());
    }

    @Test
    public void testAddPurchasePointsTwoPoints() {
        customer.purchasePoints(validCash.multipliedBy(2).plus((smallCash)));
        assertEquals(12, customer.getPurchasePoints());
    }

    @Test
    public void testDiscountRemovedSmall() {
        Money result = customer.discount(1, validCash);
        assertEquals(parse("NZD 0.50"), result);
    }

    @Test
    public void testDiscountRemovedSmallPoints() {
        Money result = customer.discount(1, validCash);
        assertEquals(9, customer.getPurchasePoints());
    }

    @Test
    public void testDiscountRemovedLarge() {
        Money result = customer.discount(9, validCash);
        assertEquals(parse("NZD 4.50"), result);
    }

    @Test
    public void testDiscountRemovedLargePoints() {
        Money result = customer.discount(9, validCash);
        assertEquals(1, customer.getPurchasePoints());
    }



    @Test
    public void testDiscountRemovedMoreThanOrder() {
        customer.setPurchasePoints(30);
        Money result = customer.discount(21, validCash);
        assertEquals(parse("NZD 10.00"), result);
    }

    @Test
    public void testDiscountRemovedMoreThanOrderPoints() {
        customer.setPurchasePoints(30);
        Money result = customer.discount(21, validCash);
        assertEquals(10, customer.getPurchasePoints());
    }

}