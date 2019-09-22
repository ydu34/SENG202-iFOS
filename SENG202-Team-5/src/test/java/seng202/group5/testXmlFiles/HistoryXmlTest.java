package seng202.group5.testXmlFiles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seng202.group5.AppEnvironment;
import seng202.group5.logic.History;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HistoryXmlTest {

    AppEnvironment appEnvironment = new AppEnvironment();
    History history;
    String testDirectory = System.getProperty("user.dir") + "/src/test/java/seng202/group5/testXmlFiles";

    @BeforeEach
    public void testUnmarshalHistory() {
        try {
            appEnvironment.historyXmlToObject(testDirectory);
            history = appEnvironment.getHistory();
            assertEquals(1, history.getTransactionHistory().size());
        } catch (Exception e) {

        }
    }

    @Test
    public void testOrderItemsInOrder() {

    }

    @Test
    public void testOrderCostIsInHistory() {
        String cost = history.getTransactionHistory().get("8").getTotalCost().toString();
        assertEquals("NZD 80.00", cost);
    }

    @Test
    public void testOrderDateTimeProcessedIsInHistory() {
        LocalDateTime dateTimeProcessed = history.getTransactionHistory().get("8").getDateTimeProcessed();
        assertTrue(dateTimeProcessed instanceof LocalDateTime);
    }

    @Test
    public void testOrderIdIsInHistory() {
        String id = history.getTransactionHistory().get("8").getID();
        assertEquals("8", id);
    }

}
