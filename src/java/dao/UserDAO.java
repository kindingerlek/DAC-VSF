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
    private static String insert = "INSERT INTO public.user (cpf, rg, cnpj, email, nome,"
            + " user_type, land_phone, cell_phone, address, address_number, complement, zip_code) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    
    
    public static boolean insert(User user){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, user.getCpf());
            ps.setString(2, user.getRg());
            ps.setString(3, user.getCnpj());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getNome());
            ps.setInt(6, user.getType());
            ps.setString(7, user.getLandPhone());
            ps.setString(8, user.getCellPhone());
            ps.setString(9, user.getAddress());
            ps.setString(10, user.getAddressNumber());
            ps.setString(11, user.getComplement());
            ps.setString(12, user.getZipCode());
            
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
