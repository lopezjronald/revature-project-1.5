package CeglarekLopez.servlets;


import CeglarekLopez.model.User;
import CeglarekLopez.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateUser")
public class UpdateUserServlet extends HttpServlet {

    UserService us = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", us.getUserById(Integer.parseInt(req.getParameter("id"))));
        req.getRequestDispatcher("update-user-form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = us.getUserById(Integer.parseInt(req.getParameter("userId")));
        user.setUsername(req.getParameter("username"));
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));

        us.updateUser(user);

        resp.sendRedirect(req.getContextPath());


    }
}
