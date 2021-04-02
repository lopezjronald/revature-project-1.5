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
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;


@WebServlet(urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    UserService userService = new UserService();
    Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        try {
            List<User> userList = userService.fetchAllUsers();
            PrintWriter out = response.getWriter();
            out.print(gson.toJson(userList));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
