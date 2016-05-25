/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import java.util.List;
import model.Agency;
import model.PersonalAccount;
import model.Transaction;
import model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno
 */
public class UserTest {
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class User.
     */
    @Test
    public void testCreateAndUpdatePf() {
        System.out.println("createPf");
        
        User user = new User();
        
        user.setCpf("2");
        user.setRg("2");
        user.setEmail("2");
        user.setName("2");
        user.setPassword("2");
        user.setType(1);
        
        boolean result = user.createPf();
        assertEquals(true, result);
        
        System.out.println("updatePf");
        
        user.setAddress("123");
        user.setAddressNumber("123");
        user.setLandPhone("123");
        user.setCellPhone("123");
        user.setComplement("123");
        user.setZipCode("123");
        
        result = user.updatePf();
        assertEquals(true, result);
    }
    
}
