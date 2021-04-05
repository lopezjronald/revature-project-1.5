package CeglarekLopez.dao;

import CeglarekLopez.model.User;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserDaoTest {
    UserDao userDao = new UserDao();
    User user = userDao.getById(1);
    User newUser = new User("testerUsername", "testerPassword", "testerFirst", "testerLast", "tester@email.com", 1);


    @Order(1)
    @Test
    void getList() {
        List<User> users = userDao.getList();
        assertTrue(users.size() > 0);
    }

    @Order(2)
    @Test
    void insert() {
        int id = userDao.insert(newUser);
        assertNotNull(userDao.getById(id));
    }

    @Order(3)
    @Test
    void getById() {
        User createdUser = userDao.getById(1);
        assertEquals(1, createdUser.getId());
    }

    @Order(4)
    @Test
    void getByUserId() {
        assertEquals(1, user.getId());
    }

    @Order(5)
    @Test
    void getByUsername() {
        assertEquals("username", user.getUsername());
    }

    @Order(6)
    @Test
    void update() {
        User createdUser = new User(newUser.getUsername(), newUser.getPassword(), newUser.getFirstName(), newUser.getLastName(), newUser.getEmail(), newUser.getRoleId());
        newUser.setUsername("updateUser");
        userDao.update(newUser);
        assertNotEquals(createdUser, newUser);
    }

    @Order(7)
    @Test
    void delete() {
        userDao.delete(newUser);
    }

}