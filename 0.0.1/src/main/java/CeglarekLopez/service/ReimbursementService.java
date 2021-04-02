package CeglarekLopez.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import CeglarekLopez.dao.ReimbursementDao;
import CeglarekLopez.model.Reimbursement;

public class ReimbursementService {
	private final ReimbursementDao reimbursementDao;
	private static final Logger LOGGER = Logger.getLogger(ReimbursementService.class);
	
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
	
	public List<Reimbursement> fetchAllReimbursements() {
		return reimbursementDao.getList();
	}

	public Reimbursement getReimbursementByID(int id) {
		return reimbursementDao.getById(id);
	}

	public void updateReimbursements(int[][] i, int r) {
		reimbursementDao.updateList(i, r);
	}
}
