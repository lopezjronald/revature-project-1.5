package CeglarekLopez.dao;

import CeglarekLopez.model.Reimbursement;
import CeglarekLopez.util.HibernateReimbursementUtil;
import CeglarekLopez.util.HibernateUserUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * Purpose of this Dao is to send/retrieve info about a reimbursement
 * to/from the database. It then returns the composed Reimbursement Object.
 */

public class ReimbursementDao implements GenericDao<Reimbursement> {
    private static final Logger LOGGER = Logger.getLogger(ReimbursementDao.class);

    private Reimbursement objectConstructor(ResultSet rs) throws SQLException {
        return new Reimbursement(rs.getInt(1), rs.getFloat(2), rs.getTimestamp(3), rs.getTimestamp(4),
                rs.getString(5), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
    }

    @Override
    public List<Reimbursement> getList() {
        Session session = HibernateReimbursementUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Reimbursement> reimbursementList = session.createQuery("from Reimbursement ", Reimbursement.class).list();
        session.close();
        return reimbursementList;
    }

    @Override
    public Reimbursement getById(int id) {
        Session session = HibernateReimbursementUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Reimbursement reimbursement = session.get(Reimbursement.class, id);
        session.getTransaction().commit();
        session.close();
        return reimbursement;
    }

    @Override
    public List<Reimbursement> getByUserId(int id) {
        List<Reimbursement> l = new ArrayList<Reimbursement>();
        return l;
    }

    public Reimbursement getByUsername(String username) {
        //Empty. Reason - No use.
        return null;
    }

    @Override
    public void insert(Reimbursement r) {
        Session session = HibernateReimbursementUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(r);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Reimbursement r) {
        Session session = HibernateReimbursementUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(r);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Reimbursement reimbursement) {
        Session session = HibernateUserUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(reimbursement);
        session.getTransaction().commit();
        session.close();
    }
}
