package CeglarekLopez.util;

import CeglarekLopez.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Initial Session Factory creation failed " + ex);
            throw new ExceptionInInitializerError();
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void close() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
