/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static utilities.HibernateUtils.getSessionFactory;

/**
 *
 * @author Alisson
 */
public class UserDAO {

    public static boolean update(User user) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            transaction = session.getTransaction();
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                throw e;
            }
            System.out.println(e.getMessage());
            System.out.println("EUAHEUAHUEHAUEAHUHEAU");
            return false;
        } finally {
            session.close();
        }
    }

    public static boolean create(User user) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            transaction = session.getTransaction();
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                throw e;
            }
            return false;
        } finally {
            session.close();
        }
    }

    public static List<User> readAll() {
        Session session = null;
        List<User> list = new ArrayList();
        try {
            session = getSessionFactory().openSession();
            list = session.createCriteria(User.class).list();
        } catch (Exception e) {
            System.out.println("readAll User");
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return list;
    }

    public static User read(User user) {
        Session session = null;
        User userReturned = new User();
        try {
            session = getSessionFactory().openSession();
            Query query = session.createQuery("from User where email = :email");
            query.setParameter("email", user.getEmail());
            userReturned = (User) query.uniqueResult();
        } catch (Exception e) {
            System.out.println("read user");
        } finally {
            session.close();
            return userReturned;
        }
    }

    public static List<User> readAll(String type, String param) {
        Transaction transaction = null;
        Session session = null;
        List<User> list = new ArrayList();
        try {
            session = getSessionFactory().openSession();
            Query query = session.createQuery("from User where " + type + " like :param");
            query.setParameter("param", "%" + param + "%");
            list = query.list();
        } catch (Exception e) {
            System.out.println("Error readAll Users");
        } finally {
            session.close();
        }
        return list;
    }

    public static boolean delete(User user) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            transaction = session.getTransaction();
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                throw e;
            }
            return true;
        } finally {
            session.close();
        }
    }
}
