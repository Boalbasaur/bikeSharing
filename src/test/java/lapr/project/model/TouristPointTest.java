/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Daniela Vinagreiro
 */
public class TouristPointTest {
    
    private final TouristPoint touristPoint1;
    private final TouristPoint touristPoint2;
    private final TouristPoint touristPoint3;
    private final TouristPoint touristPoint4;

    public TouristPointTest() {
         touristPoint1 = new TouristPoint(1,"Aliados", 48.5f, 48.5f, 25f);
         touristPoint2 = new TouristPoint(2,"Marquês", 49.5f, 49.5f, 24f);
         touristPoint3 = new TouristPoint(3,"Torre dos Clérigos", 43.5f, 48.5f, 25f);
         touristPoint4 = new TouristPoint(4,"Piolho", 45.5f, 48.5f, 25f);
    }

    /**
     * Test of getTouristPoint method, of class TouristPoint.
     */
    @Test
    public void testGetTouristPoint() {
        System.out.println("getTouristPoint");
        int idTouristPoint = 1;
        TouristPoint expResult = new TouristPoint(1,"Torre dos Clérigos", 48.5f, 48.6f, 28.4f);
        TouristPoint result = TouristPoint.getTouristPoint(idTouristPoint);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDistanceBetweenTwoTouristPoints method, of class TouristPoint.
     */
    @Test
    public void testGetDistanceBetweenTwoTouristPoints() {
        System.out.println("getDistanceBetweenTwoTouristPoints");
        TouristPoint toCheck = touristPoint1;
        TouristPoint touristPoint = touristPoint2;
        double expResult = 132.98953985877088;
        double result = TouristPoint.getDistanceBetweenTwoTouristPoints(toCheck, touristPoint);
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdTouristPoint method, of class TouristPoint.
     */
    @Test
    public void testGetIdTouristPoint() {
        System.out.println("getIdTouristPoint");
        int expResult = 1;
        int result = touristPoint1.getIdTouristPoint();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class TouristPoint.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "Marquês";
        String result = touristPoint2.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLongitude method, of class TouristPoint.
     */
    @Test
    public void testGetLongitude() {
        System.out.println("getLongitude");
        float expResult = 48.5f;
        float result = touristPoint1.getLongitude();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLatitude method, of class TouristPoint.
     */
     @Test
    public void testGetLatitude() {
        System.out.println("getLatitude");
        float expResult = 48.5f;
        float result = touristPoint1.getLatitude();
        assertEquals(expResult, result);
    }


    /**
     * Test of getAltitude method, of class TouristPoint.
     */
    @Test
    public void testGetAltitude() {
        System.out.println("getAltitude");
        float expResult = 25f;
        float result = touristPoint4.getAltitude();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdTouristPoint method, of class TouristPoint.
     */
    @Test
    public void testSetIdTouristPoint() {
        System.out.println("setIdTouristPoint");
        int idTouristPoint = 1;
        touristPoint1.setIdTouristPoint(idTouristPoint);
    }

    /**
     * Test of setName method, of class TouristPoint.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Aliados";
        touristPoint1.setDescription(name);
    }

    /**
     * Test of setLongitude method, of class TouristPoint.
     */
    @Test
    public void testSetLongitude() {
        System.out.println("setLongitude");
        float longitude = 48.5f;
        touristPoint1.setLongitude(longitude);
    }

    /**
     * Test of setLatitude method, of class TouristPoint.
     */
    @Test
    public void testSetLatitude() {
        System.out.println("setLatitude");
        float latitude = 48.5f;
        touristPoint1.setLatitude(latitude);
    }

    /**
     * Test of setAltitude method, of class TouristPoint.
     */
    @Test
    public void testSetAltitude() {
        System.out.println("setAltitude");
        float altitude = 25f;
        touristPoint1.setAltitude(altitude);
    }

    /**
     * Test of hashCode method, of class TouristPoint.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        TouristPoint instance = new TouristPoint();
        int expResult = -1779633265;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class TouristPoint.
     */
    @Test
    public void testEqualsSameTouristPoint() {
        System.out.println("equals");
        TouristPoint obj = new TouristPoint (2,"Marquês", 49.5f, 49.5f, 24f);
        boolean expResult = true;
        boolean result = touristPoint2.equals(obj);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEqualsToDifferenTouristPoint() {
        System.out.println("Test equals to different tourist points");
        TouristPoint otherTouristPoint = new TouristPoint(4,"Torre dos Clérigos", 43.5f, 48.5f, 25f);
        boolean expResult = false;
        boolean result = touristPoint3.equals(otherTouristPoint);
        assertEquals(expResult, result);
    }

        @Test
    public void testEqualsToNull() {
        System.out.println("Test equals to Null");
        TouristPoint otherTouristPoint = null;
        boolean expResult = false;
        boolean result = touristPoint3.equals(otherTouristPoint);
        assertEquals(expResult, result);
    }

    @Test
    public void testEqualsToDifferentID() {
        System.out.println("Test equals to tourist point with different id");
        TouristPoint otherTouristPoint = new TouristPoint(2,"Torre dos Clérigos", 43.5f, 48.5f, 25f);
        boolean expResult = false;
        boolean result = (touristPoint3).equals(otherTouristPoint);
        assertEquals(expResult, result);
    }

    @Test
    public void testEqualsToDifferentName() {
        System.out.println("Test equals to user with different name");
        TouristPoint otherTouristPoint = new TouristPoint(3,"ISEP", 43.5f, 48.5f, 25f);
        boolean expResult = false;
        boolean result = (touristPoint3).equals(otherTouristPoint);
        assertEquals(expResult, result);
    }

    @Test
    public void testEqualsToDifferentLatitude() {
        System.out.println("Test equals to tourist point with different latitude");
        TouristPoint otherTouristPoint = new TouristPoint(3,"Torre dos Clérigos", 42.5f, 48.5f, 25f);
        boolean expResult = false;
        boolean result = (touristPoint3).equals(otherTouristPoint);
        assertEquals(expResult, result);
    }

    @Test
    public void testEqualsToDifferentLongitude() {
        System.out.println("Test equals to tourist point with different longitude");
        TouristPoint otherTouristPoint = new TouristPoint(3,"Torre dos Clérigos", 43.5f, 41.5f, 25f);
        boolean expResult = false;
        boolean result = (touristPoint3).equals(otherTouristPoint);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEqualsToDifferentAltitude() {
        System.out.println("Test equals to tourist point with different altitude");
        TouristPoint otherTouristPoint = new TouristPoint(3,"Torre dos Clérigos", 43.5f, 48.5f, 21f);
        boolean expResult = false;
        boolean result = (touristPoint3).equals(otherTouristPoint);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testEqualsDifferentObject() {
        System.out.println("Test equals to different object");
        String otherTouristPoint = "teste";
        boolean expResult = false;
        boolean result = touristPoint1.equals(otherTouristPoint);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEqualsSameObject() {
        System.out.println("Test equals to same object");
        TouristPoint otherTouristPoint = new TouristPoint(3,"Torre dos Clérigos", 43.5f, 48.5f, 21f);
        boolean expResult = true;
        boolean result = otherTouristPoint.equals(otherTouristPoint);
        assertEquals(expResult, result);
    }
    

    /**
     * Test of toString method, of class TouristPoint.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "TouristPoints" + "idTouristPoint=" + 4 + ", name=" + "Piolho" + ", latitude=" + 45.5f + ", longitude=" + 48.5f + ", altitude=" + 25f;
        String result = touristPoint4.toString();
        assertEquals(expResult, result);
    }

}
