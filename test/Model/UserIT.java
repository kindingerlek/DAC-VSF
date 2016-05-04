/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alisson
 */
public class UserIT {
    
    public UserIT() {
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
    public void testGetId() {
        System.out.println("getId");
        User instance = new User();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class User.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        User instance = new User();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = new User();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        User instance = new User();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = new User();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        User instance = new User();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isActive method, of class User.
     */
    @Test
    public void testIsActive() {
        System.out.println("isActive");
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.isActive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setActive method, of class User.
     */
    @Test
    public void testSetActive() {
        System.out.println("setActive");
        boolean active = false;
        User instance = new User();
        instance.setActive(active);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLandPhone method, of class User.
     */
    @Test
    public void testGetLandPhone() {
        System.out.println("getLandPhone");
        User instance = new User();
        String expResult = "";
        String result = instance.getLandPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLandPhone method, of class User.
     */
    @Test
    public void testSetLandPhone() {
        System.out.println("setLandPhone");
        String landPhone = "";
        User instance = new User();
        instance.setLandPhone(landPhone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCellPhone method, of class User.
     */
    @Test
    public void testGetCellPhone() {
        System.out.println("getCellPhone");
        User instance = new User();
        String expResult = "";
        String result = instance.getCellPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCellPhone method, of class User.
     */
    @Test
    public void testSetCellPhone() {
        System.out.println("setCellPhone");
        String cellPhone = "";
        User instance = new User();
        instance.setCellPhone(cellPhone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class User.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        User instance = new User();
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class User.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        User instance = new User();
        instance.setAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddressNumber method, of class User.
     */
    @Test
    public void testGetAddressNumber() {
        System.out.println("getAddressNumber");
        User instance = new User();
        String expResult = "";
        String result = instance.getAddressNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddressNumber method, of class User.
     */
    @Test
    public void testSetAddressNumber() {
        System.out.println("setAddressNumber");
        String addressNumber = "";
        User instance = new User();
        instance.setAddressNumber(addressNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComplement method, of class User.
     */
    @Test
    public void testGetComplement() {
        System.out.println("getComplement");
        User instance = new User();
        String expResult = "";
        String result = instance.getComplement();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComplement method, of class User.
     */
    @Test
    public void testSetComplement() {
        System.out.println("setComplement");
        String complement = "";
        User instance = new User();
        instance.setComplement(complement);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getZipCode method, of class User.
     */
    @Test
    public void testGetZipCode() {
        System.out.println("getZipCode");
        User instance = new User();
        String expResult = "";
        String result = instance.getZipCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setZipCode method, of class User.
     */
    @Test
    public void testSetZipCode() {
        System.out.println("setZipCode");
        String zipCode = "";
        User instance = new User();
        instance.setZipCode(zipCode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccountList method, of class User.
     */
    @Test
    public void testGetAccountList_0args() {
        System.out.println("getAccountList");
        User instance = new User();
        List<PersonalAccount> expResult = null;
        List<PersonalAccount> result = instance.getAccountList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccountList method, of class User.
     */
    @Test
    public void testSetAccountList() {
        System.out.println("setAccountList");
        List<PersonalAccount> accountList = null;
        User instance = new User();
        instance.setAccountList(accountList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccountList method, of class User.
     */
    @Test
    public void testGetAccountList_int() {
        System.out.println("getAccountList");
        int indexPersonalAccount = 0;
        User instance = new User();
        PersonalAccount expResult = null;
        PersonalAccount result = instance.getAccountList(indexPersonalAccount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class User.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.create();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class User.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        User instance = new User();
        User expResult = null;
        User result = instance.read();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class User.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.update();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class User.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.delete();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of auth method, of class User.
     */
    @Test
    public void testAuth() {
        System.out.println("auth");
        String email = "";
        String senha = "";
        User expResult = null;
        User result = User.auth(email, senha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAmount method, of class User.
     */
    @Test
    public void testGetAmount() {
        System.out.println("getAmount");
        User instance = new User();
        float expResult = 0.0F;
        float result = instance.getAmount();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccount method, of class User.
     */
    @Test
    public void testGetAccount() {
        System.out.println("getAccount");
        int number = 0;
        Agency agency = null;
        User instance = new User();
        PersonalAccount expResult = null;
        PersonalAccount result = instance.getAccount(number, agency);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExtract method, of class User.
     */
    @Test
    public void testGetExtract() {
        System.out.println("getExtract");
        PersonalAccount account = null;
        User instance = new User();
        List<Transaction> expResult = null;
        List<Transaction> result = instance.getExtract(account);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
