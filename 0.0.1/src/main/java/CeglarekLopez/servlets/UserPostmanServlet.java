package CeglarekLopez.servlets;

import CeglarekLopez.model.User;
import CeglarekLopez.service.UserService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/usersPostman")
public class UserPostmanServlet extends HttpServlet {

    UserService us = new UserService();
    Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> usersList = us.fetchAllUsers();
        String usersJson = gson.toJson(usersList);
        resp.getWriter().print(usersJson);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String roleId = req.getParameter("roleId");
        User user = new User(username, password, firstName, lastName, email, Integer.parseInt(roleId));
        us.newUser(user);
    }
}
