/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Agency;
import org.hibernate.Query;
import org.hibernate.Session;
import static utilities.HibernateUtils.getSessionFactory;

/**
 *
 * @author Mei (Jessyka Alycia Amaral)
 */
public class AgencyDAO {
    
    public static Agency read(int agency_number) {
        Session session = getSessionFactory().openSession();
        Agency agency;
        Query query = session.createQuery("from Agency where agency_number = :agency_number");
        query.setParameter("agency_number", agency_number);
        agency = (Agency) query.uniqueResult();
        session.close();
        return agency;
    }
    
    public static void update(Agency agency){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.update(agency);
        session.getTransaction().commit();
        session.close();
    }
    
    public static void create(Agency agency) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(agency);
        session.getTransaction().commit();
        session.close();
    }
    
    public static List<Agency> readAll(){
        Session session = getSessionFactory().openSession();
        List<Agency> list = session.createCriteria(Agency.class).list();
        session.close();
        return list;
    }
    
    public static List<Agency> readAll(String type, String param) {
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery("from Agency where "+type+" like :param");
        query.setParameter("param", "%"+param+"%");
        List<Agency> list = query.list();
        session.close();
        return list;
    }
    
    public static void delete(Agency agency){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(agency);
        session.getTransaction().commit();
        session.close();
    }

}
