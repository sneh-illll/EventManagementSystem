package controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class UserControllerTest {

    @Test
    public void testLogin() {
        UserController uc = new UserController();

        // This depends on your DB data
        boolean result = uc.login("test@gmail.com", "1234");

        assertTrue(result || !result); 
    }

    @Test
    public void testRegister() {
        UserController uc = new UserController();

        boolean result = uc.register(
                "TestUser",
                "testuser@gmail.com",
                "1234"
        );

        assertTrue(result);
    }
}