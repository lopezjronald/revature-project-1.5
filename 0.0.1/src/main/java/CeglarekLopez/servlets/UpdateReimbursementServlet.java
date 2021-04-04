package CeglarekLopez.servlets;


import CeglarekLopez.model.Reimbursement;
import CeglarekLopez.model.User;
import CeglarekLopez.service.ReimbursementService;
import CeglarekLopez.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateReimbursement")
public class UpdateReimbursementServlet extends HttpServlet {

    ReimbursementService rs = new ReimbursementService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("reimbursement", rs.getReimbursementByID(Integer.parseInt(req.getParameter("id"))));
        req.getRequestDispatcher("update-reimbursement-form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Reimbursement reimbursement = rs.getReimbursementByID(Integer.parseInt(req.getParameter("reimbursementId")));
        reimbursement.setAmount(Float.parseFloat(req.getParameter("amount")));
        reimbursement.setDescription(req.getParameter("description"));

        rs.updateReimbursement(reimbursement);

        resp.sendRedirect(req.getContextPath());


    }
}
