/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;


import org.junit.jupiter.api.Test;
//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Daniela Vinagreiro
 */
public class UserTest {

    private final User normalUser;
    private final User administratorUser;

    public UserTest() {
        normalUser = new User("João Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "User",0,10f);
        administratorUser = new User("Rui Manuel", "ruManel", "ruiManuel@gmail.com", "ruil321", "1534567890123456", 1.56, 65, "Administrator",0,10f);
    }
    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "João Miguel";
        String result = normalUser.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        String expResult = "joaoMiguel96";
        String result = normalUser.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String expResult = "joaoMiguel@gmail.com";
        String result = normalUser.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        String expResult = "joao123miguel321";
        String result = normalUser.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCreditCardNumber method, of class User.
     */
    @Test
    public void testGetCreditCardNumber() {
        System.out.println("getCreditCardNumber");
        User instance = new User();
        String expResult = "1234567890123456";
        String result = normalUser.getCreditCardNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHeight method, of class User.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        double expResult = 1.88;
        double result = normalUser.getHeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWeight method, of class User.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        double expResult = 78;
        double result = normalUser.getWeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of getType method, of class User.
     */
    @Test
    public void testGetTypeUser() {
        System.out.println("getType user");
        String expResult = "User";
        String result = normalUser.getType();
        assertEquals(expResult, result);
    }
    /**
     * Test of getType method, of class User.
     */
    @Test
    public void testGetTypeAministrator() {
        System.out.println("getType administrator");
        String expResult = "Administrator";
        String result = administratorUser.getType();
        assertEquals(expResult, result);
    }
    /**
     * Test of setName method, of class User.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Rui Manuel";
        administratorUser.setName(name);
    }

    /**
     * Test of setUsername method, of class User.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "ruManel";
        administratorUser.setUsername(username);
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "ruiManuel@gmail.com";
        administratorUser.setEmail(email);
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "ruil321";
        administratorUser.setPassword(password);
    }

    /**
     * Test of setCreditCardNumber method, of class User.
     */
    @Test
    public void testSetCreditCardNumber() {
        System.out.println("setCreditCardNumber");
        String creditCardNumber = "1534567890123456";
        administratorUser.setCreditCardNumber(creditCardNumber);
    }

    /**
     * Test of setHeight method, of class User.
     */
    @Test
    public void testSetHeight() {
        System.out.println("setHeight");
        double height =  1.56;
        administratorUser.setHeight(height);
    }

    /**
     * Test of setWeight method, of class User.
     */
    @Test
    public void testSetWeight() {
        System.out.println("setWeight");
        double weight = 65;
        administratorUser.setWeight(weight);
    }

    @Test
    public void testEqualsToSameUsers() {
        System.out.println("Test equals to same users");
        User otherUser = new User("João Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "user",0,10f);
        boolean expResult = true;
        boolean result = normalUser.equals(otherUser);
        assertEquals(expResult, result);
    }

    @Test
    public void testEqualsToDifferentUsers() {
        System.out.println("Test equals to different users");
        User otherUser = new User("Rui Manuel", "ruManel", "ruiManuel@gmail.com", "ruil321", "1534567890123456", 1.56, 65, "administrator",0,10f);
        boolean expResult = false;
        boolean result = normalUser.equals(otherUser);
        assertEquals(expResult, result);
    }

        @Test
    public void testEqualsToNull() {
        System.out.println("Test equals to Null");
        User otherUser = null;
        boolean expResult = false;
        boolean result = normalUser.equals(otherUser);
        assertEquals(expResult, result);
    }

    @Test
    public void testEqualsToDifferentName() {
        System.out.println("Test equals to user with different name");
        User otherUser = new User("João Miguel_2", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "User",0,10f);
        boolean expResult = false;
        boolean result = (normalUser).equals(otherUser);
        assertEquals(expResult, result);
    }

    @Test
    public void testEqualsToDifferentUsername() {
        System.out.println("Test equals to user with different username");
        User otherUser = new User("João Miguel", "joaoMiguel967", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "user",0,10f);
        boolean expResult = false;
        boolean result = (normalUser).equals(otherUser);
        assertEquals(expResult, result);
    }

    @Test
    public void testEqualsToDifferentEmail() {
        System.out.println("Test equals to user with different email");
        User otherUser = new User("João Miguel", "joaoMiguel96", "joaomikeMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "user",0,10f);
        boolean expResult = false;
        boolean result = (normalUser).equals(otherUser);
        assertEquals(expResult, result);
    }

    @Test
    public void testEqualsToDifferentPassword() {
        System.out.println("Test equals to user with different password");
        User otherUser = new User("João Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joaomike123miguel321", "1234567890123456", 1.88, 78, "user",0,10f);
        boolean expResult = false;
        boolean result = (normalUser).equals(otherUser);
        assertEquals(expResult, result);
    }

    @Test
    public void testEqualsToDifferentCreditCardNumber() {
        System.out.println("Test equals to user with different credit card number");
        User otherUser = new User("João Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1264567890123456", 1.88, 78, "user",0,10f);
        boolean expResult = false;
        boolean result = (normalUser).equals(otherUser);
        assertEquals(expResult, result);
    }

    @Test
    public void testEqualsToDifferentHeight() {
        System.out.println("Test equals to user with different height");
        User otherUser = new User("João Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.8801, 78, "user",0,10f);
        boolean expResult = false;
        boolean result = (normalUser).equals(otherUser);
        assertEquals(expResult, result);
    }

    @Test
    public void testEqualsToDifferentWeight() {
        System.out.println("Test equals to user with different weight");
        User otherUser = new User("João Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78.0001, "user",0,10f);
        boolean expResult = false;
        boolean result = (normalUser).equals(otherUser);
        assertEquals(expResult, result);
    }

    
    @Test
    public void testEqualsSameObject() {
        System.out.println("Test equals to user with different name");
        User otherUser = new User("João_Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "user",0,10f);
        boolean expResult = true;
        boolean result = otherUser.equals(otherUser);
        assertEquals(expResult, result);
    }
    
        @Test
    public void testEqualsDifferentObject() {
        System.out.println("Test equals to different object");
        String otherUser = "teste";
        boolean expResult = false;
        boolean result = normalUser.equals(otherUser);
        assertEquals(expResult, result);
    }
    /**
     * Test of hashCode method, of class User.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        User instance = new User();
        int expResult = 490049875;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of isUser method, of class User.
     */
    @Test
    public void testIsUser() {
        System.out.println("isUser");
        boolean expResult = true;
        boolean result = normalUser.isUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAdministrator method, of class User.
     */
    @Test
    public void testIsAdministrator() {
        System.out.println("isAdministrator");
        boolean expResult = true;
        boolean result = administratorUser.isAdministrator();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "name=" + "João Miguel" + ", username=" + "joaoMiguel96" + ", email=" + "joaoMiguel@gmail.com" + ", password=" + "joao123miguel321" + ", creditCardNumber=" + "1234567890123456" + ", height=" +1.88 + ", weight=" + 78.0+ ", average speed=" + 10.0;
        String result = normalUser.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of login method, of class User.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "administrador";
        String password = "qwerty";
        boolean expResult = false;
        boolean result = User.login(username,"wrongPassword");
        assertEquals(expResult, result);
        expResult = true;
        result = User.login(username, password);
        assertEquals(expResult, result);
        expResult = false;
        result = User.login("NomeDeTesteParaLogin","passwordRandom");
        assertEquals(expResult, result);
    }

    /**
     * Test of getPoints method, of class User.
     */
    @Test
    public void testGetPoints() {
        System.out.println("getPoints");
        User instance = new User("João_Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "user",0,10f);
        int expResult = 0;
        int result = instance.getPoints();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPoints method, of class User.
     */
    @Test
    public void testSetPoints() {
        System.out.println("setPoints");
        int points = 1;
        User instance = new User("João_Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "user",0,10f);
        instance.setPoints(points);
    }

    /**
     * Test of getType method, of class User.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        User instance = normalUser;
        String expResult = "User";
        String result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAvgSpeed method, of class User.
     */
    @Test
    public void testGetAvgSpeed() {
        System.out.println("getAvgSpeed");
        User instance = normalUser;
        double expResult = 10.0;
        double result = instance.getAvgSpeed();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of setAvgSpeed method, of class User.
     */
    @Test
    public void testSetAvgSpeed() {
        System.out.println("setAvgSpeed");
        double avgSpeed = 11.0;
        User instance = new User();
        instance.setAvgSpeed(avgSpeed);
        double expResult = 11.0;
        double result = instance.getAvgSpeed();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object anotherObject = normalUser;
        User instance = new User("João Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "User",0,11f);
        boolean expResult = false;
        boolean result = instance.equals(anotherObject);
        assertEquals(expResult, result);
    }


}
