package seng202.group5;

import org.joda.money.Money;
import seng202.group5.exceptions.InsufficientCashException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Till class keeps track of held denominations value and how many are held. Has methods to calculate the total amount
 * held and methods to calculate change.
 *
 * @author James Kwok
 */
public class Till {

    private HashMap<Money, Integer> denominations;


    public Till(ArrayList<Money> moneyList) {
        denominations = new HashMap<Money, Integer>();
        for (int i = 0; i < moneyList.size(); i++) {
            denominations.put(moneyList.get(i), 0);
        }
    }

    public Till(HashMap<Money, Integer> tempDenominations) {
        denominations = tempDenominations;
}
    /**
    * Adds the given value to the denominations stored. If a given denomination does not exist, it is added to the
     * denominations HashMap.
     * @param value holds the value of a denomination using Joda Money.
     * @param count The number of denominations to be added.
     */
    public void addDenomination(Money value, int count) {
        if (denominations.containsKey(value)) {
            count += denominations.get(value);
        }
        denominations.put(value, count);
    }

    /**
     * Removes a number stated by count worth of denominations from the held denominations. Assumes only valid money
     * values will be selected from other methods.
     * @param value holds the value of a denomination using Joda Money.
     * @param count The number of denominations to be added.
     * @throws InsufficientCashException when there are not enough denominations to remove.
     */
    public void removeDenomination(Money value, int count) throws InsufficientCashException { //Requires an exception.
        if (denominations.containsKey(value)) {
            count -= denominations.get(value);
                if (count < 0) {
                    throw new InsufficientCashException("Not enough denominations exist.");
                } else {
                    denominations.put(value, count);
                }
        }
    }

    /**
     * Adds multiple denominations by calling addDenomination multiple times.
     * Further assumes that only valid money values wil be selected from other methods.
     * @param valueMap Uses the Money type as a key and the number of denominations to be removed.
     */
    public void addDenominations(HashMap<Money, Integer> valueMap) {
        for (Money moneyKey : valueMap.keySet()) {
            int count = valueMap.get(moneyKey);
            addDenomination(moneyKey, count);
        }
    }

    /**
     * Returns the total amount of money held as a sum.
     * Calls Joda-Moneys method multipliedBy().
     */
    public Money totalValue() {
        Money totalSum = Money.parse("NZD 0.00");
        ArrayList<Money> moneyArrayList = new ArrayList<Money>();
        for (Money moneyKey : denominations.keySet()) {
            int count = denominations.get(moneyKey);
            moneyArrayList.add(moneyKey.multipliedBy(count));
        }
        totalSum = Money.total(moneyArrayList);
        return totalSum;
    }

    public HashMap<Money, Integer> getDenominations() {
        return denominations;
    }
}
