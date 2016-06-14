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
import model.AccountTransaction;
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
    public void testCreateAndUpdateUser() {
        System.out.println("createUser");
        
        User user = new User();
        
        user.setCpf("cpfTest");
        user.setRg("rgTest");
        user.setEmail("test@email");
        user.setName("nameTest");
        user.setPassword("passTest");
        user.setType(1);
        
        boolean result = user.create();
        assertEquals(true, result);
        
        System.out.println("readUser");
        user = user.read();
        
        System.out.println("updateUser");
        
        user.setCity("cityTest");
        user.setNeighborhood("neighborhoodTest");
        user.setState("stateTest");
        user.setStreet("streetTest");
        user.setAddressNumber("addNumTest");
        user.setLandPhone("landPhoneTest");
        user.setCellPhone("cellPhoneTest");
        user.setComplement("complementTest");
        user.setZipCode("zipTest");
        
        result = user.update();
        assertEquals(true, result);
        
        System.out.println("deleteUser");
        result = user.delete();
        assertEquals(true, result);
        
        Agency ag = new Agency();
        ag.setNumber("12345");
        ag.create();
        
        ag = new Agency();
        ag.setNumber("76543");
        ag.create();
        
        ag = new Agency();
        ag.setNumber("97865");
        ag.create();
    }
    
}
