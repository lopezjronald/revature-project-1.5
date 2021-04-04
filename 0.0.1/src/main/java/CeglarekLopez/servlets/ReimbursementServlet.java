package CeglarekLopez.servlets;

import CeglarekLopez.model.Reimbursement;
import CeglarekLopez.service.ReimbursementService;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;


@WebServlet(urlPatterns = "/reimbursements")
public class ReimbursementServlet extends HttpServlet {
    ReimbursementService reimbursementService = new ReimbursementService();
    Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String command = request.getParameter("command");
            if (command == null) {
                command = "LIST_REIMBURSEMENT";
            }
            switch (command) {
                case "LIST_REIMBURSEMENT":
                    listReimbursements(request, response);
                    break;
                case "ADD":
                    addReimbursement(request, response);
                    break;
                case "DELETE":
                    deleteReimbursement(request, response);
                    break;
                default:
                    listReimbursements(request, response);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void listReimbursements(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Reimbursement> reimbursements = reimbursementService.fetchAllReimbursements();
            String reimbursementJson = gson.toJson(reimbursements);
            request.setAttribute("REIMBURSEMENT_LIST", reimbursements);
            request.setAttribute("REIMBURSEMENT_JSON", reimbursementJson);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/list-reimbursement.jsp");
            dispatcher.forward(request, response);
        } catch (IOException | ServletException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addReimbursement(HttpServletRequest request, HttpServletResponse response) {
        float amount = Float.parseFloat(request.getParameter("amount"));
        java.sql.Timestamp submitted = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        java.sql.Timestamp resolved = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        String description = request.getParameter("description");
        int authorId = Integer.parseInt(request.getParameter("authorId"));
        int resolverId = Integer.parseInt(request.getParameter("resolverId"));
        int statusId = Integer.parseInt(request.getParameter("statusId"));
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        Reimbursement reimbursement = new Reimbursement(amount, submitted, resolved, description, authorId, resolverId, statusId, typeId);
        reimbursementService.newReimbursement(reimbursement);
        listReimbursements(request, response);
    }

    private void deleteReimbursement(HttpServletRequest request, HttpServletResponse response) {
        String reimbursementId = request.getParameter("id");
        Reimbursement reimbursement = reimbursementService.getReimbursementByID(Integer.parseInt(reimbursementId));
        reimbursementService.removeReimbursement(reimbursement);
        listReimbursements(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
