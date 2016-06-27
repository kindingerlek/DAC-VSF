/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Agency;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static utilities.HibernateUtils.getSessionFactory;

/**
 *
 * @author Alisson
 */
public class AgencyDAO {

    public static boolean update(Agency agency) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.update(agency);
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
            session.close();
            return false;
        }
    }

    public static boolean create(Agency agency) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(agency);
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

    public static List<Agency> readAll() {
        Session session = null;
        List<Agency> list = new ArrayList();
        try {
            session = getSessionFactory().openSession();
            list = session.createCriteria(Agency.class).list();
        } catch (Exception e) {
            System.out.println("readAll Agency");
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return list;
    }

    public static Agency read(Agency agency) {
        Session session = null;
        Agency agencyReturned = new Agency();
        try {
            session = getSessionFactory().openSession();
            Query query = session.createQuery("from Agency where number = :number");
            query.setParameter("number", agency.getNumber());
            agencyReturned = (Agency) query.uniqueResult();
        } catch (Exception e) {
            System.out.println("read agency " + e);
        } finally {
            session.close();
            return agencyReturned;
        }
    }

    public static boolean delete(Agency agency) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(agency);
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
