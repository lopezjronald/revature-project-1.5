package CeglarekLopez;

import CeglarekLopez.dao.ReimbursementDao;
import CeglarekLopez.model.Reimbursement;
import CeglarekLopez.model.User;
import CeglarekLopez.service.ReimbursementService;
import CeglarekLopez.service.UserService;

public class Driver {

    public static void main(String[] args) {

        UserService userService = new UserService();
        ReimbursementDao reimbursementDao = new ReimbursementDao();

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

        Reimbursement reimbursement = reimbursementDao.getById(1);
        System.out.println(reimbursement.toString());

    }
}
