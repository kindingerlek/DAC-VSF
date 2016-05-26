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
        
        user.setCpf("cpfTest");
        user.setRg("rgTest");
        user.setEmail("testPf@email");
        user.setName("namePfTest");
        user.setPassword("passTest");
        user.setType(1);
        
        boolean result = user.createPf();
        assertEquals(true, result);
        
        System.out.println("updatePf");
        
        user.setAddress("addressTest");
        user.setAddressNumber("addNumTest");
        user.setLandPhone("landPhoneTest");
        user.setCellPhone("cellPhoneTest");
        user.setComplement("complementTest");
        user.setZipCode("zipTest");
        
        result = user.updatePf();
        assertEquals(true, result);
    }
    
    @Test
    public void testCreateAndUpdatePj() {
        System.out.println("createPj");
        
        User user = new User();
        
        user.setCnpj("cnpjTest");
        user.setFantasyName("fantasyNameTest");
        user.setEmail("testPj@email");
        user.setName("namePjTest");
        user.setPassword("passTest");
        user.setType(2);
        
        boolean result = user.createPj();
        assertEquals(true, result);
        
        System.out.println("updatePj");
        
        user.setAddress("addressTest");
        user.setAddressNumber("addNumTest");
        user.setLandPhone("landPhoneTest");
        user.setCellPhone("cellPhoneTest");
        user.setComplement("complementTest");
        user.setZipCode("zipTest");
        
        result = user.updatePj();
        assertEquals(true, result);
    }
    
}
