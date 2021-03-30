package CeglarekLopez;

import CeglarekLopez.model.User;
import CeglarekLopez.service.UserService;

public class Driver {

    public static void main(String[] args) {

        UserService userService = new UserService();

        User user = new User();

//        user.setFirstname("Steven");
//        user.setLastname("Ceglarek");
//        user.setPassword("12345678");
//        user.setEmail("sc@gmail.com");
//        user.setUsername("Ceglareks954");
//        user.setRole_id(1);
//
//        userService.user(user);
//
//        System.out.println(user);

        User newUser = userService.getUserById(10);

        System.out.println(newUser);

    }
}
