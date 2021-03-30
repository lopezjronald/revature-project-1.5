package CeglarekLopez.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User newUser;

    @BeforeEach
    void setup() {
        newUser = new User(1, "username", "password", "first", "last", "email", 1);
    }

    @Test
    void getUser_id() {
        assertEquals(1, newUser.getId());
    }

    @Test
    void getUsername() {
        assertEquals("username", newUser.getUsername());
    }

    @Test
    void getPassword() {
        assertEquals("password", newUser.getPassword());
    }

    @Test
    void getFirstname() {
        assertEquals("first", newUser.getFirstName());
    }

    @Test
    void getLastname() {
        assertEquals("last", newUser.getLastName());
    }

    @Test
    void getEmail() {
        assertEquals("email", newUser.getEmail());
    }

    @Test
    void getRole_id() {
        assertEquals(1, newUser.getRoleId());
    }

    @Test
    void setUser_id() {
    }

    @Test
    void setUsername() {
    }

    @Test
    void setPassword() {
    }

    @Test
    void setFirstname() {
    }

    @Test
    void setLastname() {
    }

    @Test
    void setEmail() {
    }

    @Test
    void setRole_id() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void canEqual() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testToString() {
    }
}
