/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import dao.AgencyDAO;
import java.util.List;
import model.Agency;

/**
 *
 * @author Mei
 */
public class Utils {
    public static List<Agency> getAllAgencies(){
        List<Agency> agencies = AgencyDAO.readAll();
        return agencies;
    }
    
    public static void verifyDebtor(){
        //TODO
    }
}
