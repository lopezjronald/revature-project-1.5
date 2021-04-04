package CeglarekLopez;

import CeglarekLopez.dao.ReimbursementDao;
import CeglarekLopez.model.Reimbursement;
import CeglarekLopez.model.User;
import CeglarekLopez.service.ReimbursementService;
import CeglarekLopez.service.UserService;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

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


//        float amount = 3000.15f;
//        java.sql.Timestamp submitted = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
//        java.sql.Timestamp resolved =  new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
//        String description = "Reimbursement " + 3;
//        int authorId = 1;
//        int resolverId = 1;
//        int statusId = 1;
//        int typeId = 1;
//
//        Reimbursement reimbursement = new Reimbursement(amount, submitted, resolved, description, authorId, resolverId, statusId, typeId);
//        reimbursementDao.insert(reimbursement);




//        User user = userService.getUserById(19);
//        System.out.println(user.toString());

        List<Reimbursement> reimbursements = reimbursementDao.getList();
        System.out.println(reimbursements);

    }
}
