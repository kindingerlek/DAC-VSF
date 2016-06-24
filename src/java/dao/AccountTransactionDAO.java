/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.AccountTransaction;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static utilities.HibernateUtils.getSessionFactory;
import model.PersonalAccount;
import org.hibernate.Query;

/**
 *
 * @author Bruno
 */
public class AccountTransactionDAO {
    
    public static boolean create(AccountTransaction accountTransaction) {
        Transaction transaction = null;  
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(accountTransaction);
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
    
    public static List<AccountTransaction> getExtract(PersonalAccount personalAccount) {
        Session session = null;
        Query query = null;
        List<AccountTransaction> transactions = null;
        try {
            session = getSessionFactory().openSession();
            query = session.createQuery("from AccountTransaction where "
                    + "account_id  = :accountId "
                    + "order by date desc");
            query.setParameter("accountId", personalAccount.getId());
            transactions = query.list();
        } catch (Exception e) {
            System.out.println("read get extract " + e);
        }
            session.close();
            return transactions;
    }
}
