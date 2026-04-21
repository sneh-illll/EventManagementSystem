package controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class EventControllerTest {

    @Test
    public void testAddEvent() {
        EventController ec = new EventController();

        boolean result = ec.addEvent(
                "Test Event",
                "2026-04-20",
                "Delhi",
                500
        );

        assertTrue(result);
    }
}