package CeglarekLopez;

import CeglarekLopez.dao.UserDao;
import CeglarekLopez.model.User;
import CeglarekLopez.service.UserService;
import CeglarekLopez.util.HibernateUtil;

import java.sql.Connection;

public class Driver {

    public static void main(String[] args) {

        UserDao userDao = new UserDao();

        int number = 4;
        String username = "username" + number;
        String password = "password" + number;
        String firstName = "firstName" + number;
        String lastName = "lastName" + number;
        String email = "email" + number;
        int roleId = 1;


        User user = new User(username, password, firstName, lastName, email, 1);

        System.out.println(user.toString());

        userDao.insert(user);

        User newUser = userDao.getById(1);

        System.out.println(newUser);

    }
}
