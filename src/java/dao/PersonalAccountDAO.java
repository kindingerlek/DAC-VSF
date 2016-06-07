/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.PersonalAccount;
import org.hibernate.Query;
import org.hibernate.Session;
import static utilities.HibernateUtils.getSessionFactory;

/**
 *
 * @author Mei (Jessyka Alycia Amaral)
 */
public class PersonalAccountDAO {
    
    public static PersonalAccount read(int id) {
        Session session = getSessionFactory().openSession();
        PersonalAccount account = new PersonalAccount();
        account.setId(id);
        Query query = session.createQuery("from PersonalAccount where id = :id");
        query.setParameter("id", account.getId());
        account = (PersonalAccount) query.uniqueResult();
        session.close();
        return account;
    }
    
    public static void update(PersonalAccount account){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.update(account);
        session.getTransaction().commit();
        session.close();
    }
    
    public static void create(PersonalAccount account) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(account);
        session.getTransaction().commit();
        session.close();
    }
    
    public static List<PersonalAccount> readAll(){
        Session session = getSessionFactory().openSession();
        List<PersonalAccount> list = session.createCriteria(PersonalAccount.class).list();
        session.close();
        return list;
    }
    
    public static List<PersonalAccount> readAll(String type, String param) {
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery("from PersonalAccount where "+type+" like :param");
        query.setParameter("param", "%"+param+"%");
        List<PersonalAccount> list = query.list();
        session.close();
        return list;
    }
    
    public static void delete(PersonalAccount account){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(account);
        session.getTransaction().commit();
        session.close();
    }
    
}
