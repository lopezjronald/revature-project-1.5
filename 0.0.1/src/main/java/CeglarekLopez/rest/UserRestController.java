package CeglarekLopez.rest;

import CeglarekLopez.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    // define endpoint for "/users" - return list of users

    @GetMapping("/users")
    public List<User> getUser(){
        List<User> users = new ArrayList<>();
        int count = 0;
        users.add(new User(count, ("username" + count), ("password"+count), ("firstName" + count), ("lastName" + count), ("email" + count), count));
        count++;
        users.add(new User(count, ("username" + count), ("password"+count), ("firstName" + count), ("lastName" + count), ("email" + count), count));
        count++;
        users.add(new User(count, ("username" + count), ("password"+count), ("firstName" + count), ("lastName" + count), ("email" + count), count));
        count++;
        users.add(new User(count, ("username" + count), ("password"+count), ("firstName" + count), ("lastName" + count), ("email" + count), count));
        return users;
    }

}
