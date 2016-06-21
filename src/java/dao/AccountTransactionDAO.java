/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.AccountTransaction;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static utilities.HibernateUtils.getSessionFactory;

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
}
