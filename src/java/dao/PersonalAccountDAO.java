/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.AccountTransaction;
import java.util.Collection;
import java.util.List;
import model.PersonalAccount;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static utilities.HibernateUtils.getSessionFactory;

/**
 *
 * @author Alisson
 */
public class PersonalAccountDAO {

    public static boolean update(PersonalAccount personalAccount) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.update(personalAccount);
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

    public static boolean create(PersonalAccount personalAccount) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(personalAccount);
            transaction = session.getTransaction();
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
                throw e;
            }
            session.close();
            return false;
        }
    }

    public static List<PersonalAccount> readAll() {
        Session session = null;
        List<PersonalAccount> list = new ArrayList();
        try {
            session = getSessionFactory().openSession();
            list = session.createCriteria(PersonalAccount.class).list();
        } catch (Exception e) {
            System.out.println("readAll PersonalAccount");
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return list;
    }

    public static PersonalAccount readByNumber(PersonalAccount personalAccount) {
        Session session = null;
        PersonalAccount personalAccountReturned = new PersonalAccount();
        try {
            session = getSessionFactory().openSession();
            Query query = session.createQuery("from PersonalAccount where number = :number");
            query.setParameter("number", personalAccount.getNumber());
            personalAccountReturned = (PersonalAccount) query.uniqueResult();
        } catch (Exception e) {
            System.out.println("read personalAccount " + e);
        } finally {
            session.close();
            return personalAccountReturned;
        }
    }
    
    public static PersonalAccount readById(PersonalAccount personalAccount) {
        Session session = null;
        PersonalAccount personalAccountReturned = new PersonalAccount();
        try {
            session = getSessionFactory().openSession();
            Query query = session.createQuery("from PersonalAccount where id = :id");
            query.setParameter("id", personalAccount.getId());
            personalAccountReturned = (PersonalAccount) query.uniqueResult();
        } catch (Exception e) {
            System.out.println("read personalAccount");
        } finally {
            session.close();
            return personalAccountReturned;
        }
    }
    
    public static PersonalAccount readByUser(PersonalAccount personalAccount) {
        Session session = null;
        PersonalAccount personalAccountReturned = new PersonalAccount();
        try {
            session = getSessionFactory().openSession();
            Query query = session.createQuery("from PersonalAccount where user = :userId");
            query.setParameter("userId", personalAccount.getUser());
            personalAccountReturned = (PersonalAccount) query.uniqueResult();
        } catch (Exception e) {
            System.out.println("read personalAccount " + e);
        } finally {
            session.close();
            return personalAccountReturned;
        }
    }
    
    public static PersonalAccount readByUserIdAndInativeStatus(PersonalAccount personalAccount) {
        Session session = null;
        PersonalAccount personalAccountReturned = new PersonalAccount();
        try {
            session = getSessionFactory().openSession();
            Query query = session.createQuery("from PersonalAccount where user = :userId and status = 'inative'");
            query.setParameter("userId", personalAccount.getUser());
            personalAccountReturned = (PersonalAccount) query.uniqueResult();
        } catch (Exception e) {
            System.out.println("read personalAccount " + e);
        } finally {
            session.close();
            return personalAccountReturned;
        }
    }
    
    public static Collection<AccountTransaction> readInTransactions(PersonalAccount personalAccount) {
        Session session = null;
        Collection<AccountTransaction> transactionsToReturn = null;
        PersonalAccount personalAccountReturned = new PersonalAccount();
        try {
            session = getSessionFactory().openSession();
            Query query = session.createQuery("from PersonalAccount where number = :number");
            query.setParameter("number", personalAccount.getNumber());
            personalAccountReturned = (PersonalAccount) query.uniqueResult();
            personalAccountReturned.getTransactionsIn().size();
            transactionsToReturn = personalAccountReturned.getTransactionsIn();
        } catch (Exception e) {
            System.out.println("read personalAccount");
        } finally {
            session.close();
            return transactionsToReturn;
        }
    }
    
     public static Collection<AccountTransaction> readOutTransactions(PersonalAccount personalAccount) {
        Session session = null;
        Collection<AccountTransaction> transactionsToReturn = null;
        PersonalAccount personalAccountReturned = new PersonalAccount();
        try {
            session = getSessionFactory().openSession();
            Query query = session.createQuery("from PersonalAccount where number = :number");
            query.setParameter("number", personalAccount.getNumber());
            personalAccountReturned = (PersonalAccount) query.uniqueResult();
            personalAccountReturned.getTransactionsOut().size();
            transactionsToReturn = personalAccountReturned.getTransactionsOut();
        } catch (Exception e) {
            System.out.println("read personalAccount");
        } finally {
            session.close();
            return transactionsToReturn;
        }
    }

    public static List<PersonalAccount> readAll(String type, String param) {
        Transaction transaction = null;
        Session session = null;
        List<PersonalAccount> list = new ArrayList();
        try {
            session = getSessionFactory().openSession();
            Query query = session.createQuery("from PersonalAccount where " + type + " like :param");
            query.setParameter("param", "%" + param + "%");
            list = query.list();
        } catch (Exception e) {
            System.out.println("Error readAll PersonalAccounts");
        } finally {
            session.close();
        }
        return list;
    }

    public static boolean delete(PersonalAccount personalAccount) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(personalAccount);
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
            return true;
        }
    }
}
