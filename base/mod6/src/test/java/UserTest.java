import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class UserTest {
    @Test
    @DisplayName("Check object creation with two parameters")
    public void testParameters() {
        User user = new User("login_test", "email_test");

        assertEquals("login_test", user.getLogin());
        assertEquals("email_test", user.getEmail());
    }

    @Nested
    @DisplayName("Check if values are set up")
    class ValuesCheck {
        @Test
        @DisplayName("Check if email is valid")
        public void testEmail () {
            User user = new User("login_test", "random@at.com");

            assertTrue(user.getEmail().contains("@") & user.getEmail().contains("."));
        }

        @Test
        @DisplayName("Check if login contains more than 5 symbols")
        public void testLogin () {
            User user = new User("random", "email_test");

            assertTrue(user.getLogin().length() >= 5);
        }
    }
}
