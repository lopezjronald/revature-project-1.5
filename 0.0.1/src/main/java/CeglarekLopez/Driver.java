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
        String username = "steven" + number;
        String password = "12345678" + number;
        String firstName = "steven" + number;
        String lastName = "ceg" + number;
        String email = "email!g.com" + number;
        int roleId = 1;


        User user = new User(username, password, firstName, lastName, email, roleId);

        System.out.println(user.toString());

        userDao.insert(user);

        User newUser = userDao.getById(1);

        System.out.println(newUser);

    }
}
