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
            + " password, user_type) VALUES (?, ?, ?, ?, ?, ?);";

    private static String insertPj = "INSERT INTO public.user (cnpj, email, name,"
            + " fantasy_name, password, user_type) VALUES (?, ?, ?, ?, ?, ?);";

    private static String updatePf = "UPDATE public.user SET cpf = ?, rg = ?, "
            + "email = ?, name = ?, user_type = ?, land_phone = ?, cell_phone = ?,"
            + " address = ?, address_number = ?, complement = ?, zip_code = ? where user_id = ?;";

    private static String updatePj = "UPDATE public.user SET cnpj = ?, email = ?, name = ?,"
            + " fantasy_name = ?, user_type = ?, land_phone = ?, cell_phone = ?, address = ?, "
            + "address_number = ?, complement = ?, zip_code = ? where user_id = ?;";

    public static boolean updatePj(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement(updatePj);

            ps.setString(1, user.getCnpj());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getName());
            ps.setString(4, user.getFantasyName());
            ps.setInt(5, user.getType());
            ps.setString(6, user.getLandPhone());
            ps.setString(7, user.getCellPhone());
            ps.setString(8, user.getAddress());
            ps.setString(9, user.getAddressNumber());
            ps.setString(10, user.getComplement());
            ps.setString(11, user.getZipCode());
            ps.setInt(12, user.getId());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error on insert user.");
        } finally {
            return false;
        }
    }

    public static boolean updatePf(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement(updatePf);

            ps.setString(1, user.getCpf());
            ps.setString(2, user.getRg());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getName());
            ps.setInt(5, user.getType());
            ps.setString(6, user.getLandPhone());
            ps.setString(7, user.getCellPhone());
            ps.setString(8, user.getAddress());
            ps.setString(9, user.getAddressNumber());
            ps.setString(10, user.getComplement());
            ps.setString(11, user.getZipCode());
            ps.setInt(12, user.getId());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error on insert user.");
        }
        return false;
    }

    public static boolean insertPj(User user) {
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
            ps.setInt(6, user.getType());

            ps.executeUpdate();

            user.setId(setID(ps));
            return true;
        } catch (SQLException ex) {
            System.out.println("Error on insert user.");
        } finally {
            return false;
        }
    }

    public static boolean insertPf(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean hasResult = false;

        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement(insertPf, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.getCpf());
            ps.setString(2, user.getRg());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getName());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getType());

            ps.executeUpdate();
            user.setId(setID(ps));
            return true;
        } catch (SQLException ex) {
            System.out.println("Error on insert user. " + ex);
        }
        System.out.println(hasResult);
        return false;
    }

    private static int setID(PreparedStatement statment) throws SQLException {
        ResultSet resultSet = statment.getGeneratedKeys();
        resultSet.next();
        return resultSet.getInt(1);
    }
}
