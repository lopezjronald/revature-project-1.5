package CeglarekLopez.servlets;

import CeglarekLopez.model.User;
import CeglarekLopez.service.UserService;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    UserService userService = new UserService();
    Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String command = request.getParameter("command");
            if (command == null) {
                command = "LIST";
            }
            switch (command) {
                case "LIST":
                    listUsers(request, response);
                    break;
                case "ADD":
                    addUser(request, response);
                    break;
                case "DELETE":
                    deleteUser(request, response);
                    break;
                default:
                    listUsers(request, response);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<User> users = userService.fetchAllUsers();
            String usersJson = gson.toJson(users);
            request.setAttribute("USER_LIST", users);
            request.setAttribute("USERS_JSON", usersJson);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/list-users.jsp");
            dispatcher.forward(request, response);
        } catch (IOException | ServletException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String roleId = request.getParameter("roleId");
        User user = new User(username, password, firstName, lastName, email, Integer.parseInt(roleId));
        userService.newUser(user);
        listUsers(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        String userId = request.getParameter("id");
        User user = userService.getUserById(Integer.parseInt(userId));
        userService.removeUser(user);
        listUsers(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
