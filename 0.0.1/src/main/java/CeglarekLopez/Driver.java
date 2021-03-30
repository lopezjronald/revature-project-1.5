package CeglarekLopez;

import CeglarekLopez.model.User;
import CeglarekLopez.service.UserService;

public class Driver {

    public static void main(String[] args) {

        UserService us = new UserService();

//        User newUser = new User();
//
//        newUser.setFirstname("Steven");
//        newUser.setLastname("Ceglarek");
//        newUser.setPassword("12345678");
//        newUser.setEmail("sc@gmail.com");
//        newUser.setUsername("Ceglareks954");
//        newUser.setRole_id(1);
//
//        us.newUser(newUser);
//
//        System.out.println(newUser);

        User steven = us.getUserById(1);

        System.out.println(steven);

    }
}
