/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;
import static utilities.HibernateUtils.getSessionFactory;

/**
 *
 * @author Mei (Jessyka Alycia Amaral)
 */
public class TransactionDAO {
    public static Transaction read(int id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = new Transaction();
        transaction.setId(id);
        Query query = session.createQuery("from Transaction where id = :id");
        query.setParameter("id", transaction.getId());
        transaction = (Transaction) query.uniqueResult();
        session.close();
        return transaction;
    }
    
    public static void update(Transaction transaction){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.update(transaction);
        session.getTransaction().commit();
        session.close();
    }
    
    public static void create(Transaction transaction) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(transaction);
        session.getTransaction().commit();
        session.close();
    }
    
    public static List<Transaction> readAll(){
        Session session = getSessionFactory().openSession();
        List<Transaction> list = session.createCriteria(Transaction.class).list();
        session.close();
        return list;
    }
    
    public static List<Transaction> readAll(String type, String param) {
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery("from Transaction where "+type+" like :param");
        query.setParameter("param", "%"+param+"%");
        List<Transaction> list = query.list();
        session.close();
        return list;
    }
    
    public static void delete(Transaction transaction){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(transaction);
        session.getTransaction().commit();
        session.close();
    }
}
