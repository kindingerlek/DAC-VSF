/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
            session.close();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                throw e;
            }
            System.out.println(e.getMessage());
            System.out.println("EUAHEUAHUEHAUEAHUHEAU");
            session.close();
            return false;
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
            session.close();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                throw e;
            }
            session.close();
            return false;
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

            if (user.getEmail()!= null && !user.getEmail().isEmpty()) {
                Query query = session.createQuery("from User where email = :email");
                query.setParameter("email", user.getEmail());
                userReturned = (User) query.uniqueResult();

            } else if (user.getCnpj()!= null && !user.getCnpj().isEmpty()) {
                Query query = session.createQuery("from User where cnpj = :cnpj");
                query.setParameter("cnpj", user.getCnpj());
                userReturned = (User) query.uniqueResult();

            } else if (user.getCpf()!= null && !user.getCpf().isEmpty()) {
                Query query = session.createQuery("from User where cpf = :cpf");
                query.setParameter("cpf", user.getCpf());
                userReturned = (User) query.uniqueResult();
            } else {
                System.out.println("User should has cpf, cnpj or email, but does not has neither");
            }
        } catch (Exception e) {
            System.out.println("read user " +e);
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
            session.close();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                throw e;
            }
            session.close();
            return false;
        }
    }
}
