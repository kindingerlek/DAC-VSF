/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author Bruno
 */
public class UserDAO {
    private static String insertPf = "INSERT INTO public.user (cpf, rg, email, name,"
            + " password) VALUES (?, ?, ?, ?, ?);";
    
    private static String insertPj = "INSERT INTO public.user (cnpj, email, name,"
            + " fantasy_name, password) VALUES (?, ?, ?, ?, ?);";
    
    public static boolean insertPj(User user){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement(insertPj, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, user.getCnpj());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getName());
            ps.setString(4, user.getFantasyName());
            ps.setString(5, user.getPassword());
            
            ps.executeQuery();
            
            user.setId(setID(ps));
            return true;
        } catch (SQLException ex) {
            System.out.println("Error on insert user.");
        } finally {
            return false;
        }
    }
    
    public static boolean insertPf(User user){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement(insertPf, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, user.getCpf());
            ps.setString(2, user.getRg());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getName());
            ps.setString(5, user.getPassword());
            
            ps.executeQuery();
            
            user.setId(setID(ps));
            return true;
        } catch (SQLException ex) {
            System.out.println("Error on insert user.");
        } finally {
            return false;
        }
    }
    
    private static int setID(PreparedStatement statment) throws SQLException {
        ResultSet resultSet = statment.getGeneratedKeys();
        resultSet.next();
        return resultSet.getInt(1);
    }
}
