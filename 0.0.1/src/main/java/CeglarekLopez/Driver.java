package CeglarekLopez;

import CeglarekLopez.dao.UserDao;
import CeglarekLopez.model.User;
import CeglarekLopez.service.UserService;

import java.util.List;

public class Driver {

    public static void main(String[] args) {

        UserService userService = new UserService();

//        int number = 11;
//        String username = "username" + number;
//        String password = "password" + number;
//        String firstName = "firstName" + number;
//        String lastName = "lastName" + number;
//        String email = "email@g.com" + number;
//        int roleId = 1;
//
//
//        User user = new User(username, password, firstName, lastName, email, roleId);
//        userService.newUser(user);

//        List<User> users = userService.fetchAllUsers();
//        for(User eachUser: users) {
//            System.out.println(eachUser.toString());
//        }

        User user = userService.getUserById(19);
        System.out.println(user.toString());
    }
}
