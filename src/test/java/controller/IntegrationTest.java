package controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class IntegrationTest {

    @Test
    public void testAddAndFetchEvent() {

        EventController ec = new EventController();

        boolean added = ec.addEvent(
                "Integration Event",
                "2026-04-20",
                "Delhi",
                500
        );

        assertTrue(added);

        assertNotNull(ec.getAllEvents());
    }
}