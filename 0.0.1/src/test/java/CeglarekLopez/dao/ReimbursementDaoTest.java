package CeglarekLopez.dao;

import CeglarekLopez.model.Reimbursement;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReimbursementDaoTest {

    ReimbursementDao reimbursementDao = new ReimbursementDao();

    Reimbursement newReimbursement = new Reimbursement(999.99f,
            new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()),
            new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()),
            "description",
            1,
            1,
            1,
            1);

    @Order(1)
    @Test
    void getList() {
        assertTrue(reimbursementDao.getList().size() > 0);
    }

    @Order(2)
    @Test
    void getById() {
        Reimbursement createdReimbursement = reimbursementDao.getById(1);
        assertEquals(1, createdReimbursement.getId());
    }

    @Test
    @Ignore
    void getByUserId() {
    }

    @Test
    @Ignore
    void getByUsername() {
    }

    @Order(3)
    @Test
    void insert() {
        int id = reimbursementDao.insert(newReimbursement);
        assertNotNull(reimbursementDao.getById(id));
    }

    @Order(4)
    @Test
    void update() {
        Reimbursement createdReimbursement = new Reimbursement(
                newReimbursement.getAmount(),
                newReimbursement.getSubmitted(),
                newReimbursement.getResolved(),
                newReimbursement.getDescription(),
                newReimbursement.getAuthor(),
                newReimbursement.getResolver(),
                newReimbursement.getStatusId(),
                newReimbursement.getTypeId()
        );
        newReimbursement.setAmount(0.01f);
        reimbursementDao.update(newReimbursement);
        assertNotEquals(newReimbursement, createdReimbursement);
    }

    @Order(5)
    @Test
    void delete() {
        reimbursementDao.delete(newReimbursement);
    }
}