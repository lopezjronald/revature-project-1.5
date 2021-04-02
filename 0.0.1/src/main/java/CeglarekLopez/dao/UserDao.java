package CeglarekLopez.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import CeglarekLopez.util.HibernateUtil;
import org.apache.log4j.Logger;

import CeglarekLopez.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

/*
 * Purpose of this Dao is to send/retrieve info about a reimbursement
 * to/from the database. It then returns the composed Reimbursement Object.
 */

public class UserDao implements GenericDao <User> {
	private static final Logger LOGGER = Logger.getLogger(UserDao.class);

	private User objectConstructor(ResultSet rs) throws SQLException {
		return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
	}
	
	@Override
	public List<User> getList() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<User> userList = session.createQuery("from User", User.class).list();
		session.close();
		return userList;
	}

	@Override
	public User getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		User user = session.get(User.class, id);
		session.getTransaction().commit();
		session.close();
		return user;
	}
	
	@Override
	public List<User> getByUserId(int id) {
		return new ArrayList<>();
	}
	
	@Override
	public User getByUsername(String username) {
		return null;
	}

	@Override
	public void insert(User t) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(User t) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(t);
		session.getTransaction().commit();
		session.close();
	}
}
