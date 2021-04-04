package CeglarekLopez.service;

import CeglarekLopez.dao.ReimbursementDao;
import CeglarekLopez.model.Reimbursement;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.util.List;

public class ReimbursementService {
    private static final Logger LOGGER = Logger.getLogger(ReimbursementService.class);
    private final ReimbursementDao reimbursementDao;

    public ReimbursementService() {
        reimbursementDao = new ReimbursementDao();
    }

    public void createReimbursement(String json) {
        try {
            Reimbursement r = new ObjectMapper().readValue(json, Reimbursement.class);
            LOGGER.debug("JSON from the client was successfully parsed.");
            reimbursementDao.insert(r);
        } catch (Exception e) {
            LOGGER.error("Something occurred during JSON parsing for a new reimbursement. Is the JSON malformed?");
            e.printStackTrace();
        }
    }

    public void newReimbursement(Reimbursement reimbursement) {
        reimbursementDao.insert(reimbursement);
    }

    public List<Reimbursement> fetchAllReimbursements() {
        return reimbursementDao.getList();
    }

    public Reimbursement getReimbursementByID(int id) {
        return reimbursementDao.getById(id);
    }

    public void updateReimbursement(Reimbursement reimbursement) {
        reimbursementDao.update(reimbursement);
    }

    public void removeReimbursement(Reimbursement reimbursement) {
        reimbursementDao.delete(reimbursement);
    }
}
