package lapr.project.model;

import lapr.project.data.BikeDB;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author franc
 */
public class BikeTest {

    private Bike bike;
    private Bike bike2;
    private Bike bike3;

    public BikeTest() {
        bike = new Bike("4", "eletric", 1, 10, 1.1, 2.2, 3f, 4f, 1);
        bike2 = new Bike("4", "eletric");
        bike3 = new Bike("4", "eletric", "1", "3", 10, 1.1, 2.2, 3f, 4f, 1);
    }

    /**
     * Test of getBike method, of class Bike.
     */
    @Test
    public void testGetBike() {
        System.out.println("getBike");
        String expId = bike.getIdBike();
        String result = Bike.getBike("4").getIdBike();
        assertEquals(expId, result);
    }

    /**
     * Test of getIdBike method, of class Bike.
     */
    @Test
    public void testGetIdBike() {
        System.out.println("getIdBike");
        String expResult = "4";
        String result = bike.getIdBike();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdType method, of class Bike.
     */
    @Test
    public void testGetIdType() {
        System.out.println("getIdType");
        String expResult = "eletric";
        String result = bike2.getIdType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAvailability method, of class Bike.
     */
    @Test
    public void testGetAvailability() {
        System.out.println("getAvailability");
        int expResult = 1;
        int result = bike.getAvailability();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBattery method, of class Bike.
     */
    @Test
    public void testGetBattery() {
        System.out.println("getBattery");
        String expResult = "1";
        String result = bike3.getBattery();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetMaxCapacity() {
        System.out.println("getMaxCapacity");
        String expResult = null;
        String result = bike.getMaxCapacity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdType method, of class Bike.
     */
    @Test
    public void testSetIdType() {
        System.out.println("setIdType");
        bike.setIdType("road");
        String expResult = "road";
        String result = bike.getIdType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAvailability method, of class Bike.
     */
    @Test
    public void testSetAvailability() {
        System.out.println("setAvailability");
        bike.setAvailability(1);
        int expResult = 1;
        int result = bike.getAvailability();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBattery class Bike.
     */
    @Test
    public void testSetBattery() {
        System.out.println("setAvailability");
        bike.setBattery("100");
        String expResult = "100";
        String result = bike.getBattery();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Bike.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "ID Bike: 4 Type: eletric Availability: 1";
        String result = bike.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRoadWeight method, of class Bike.
     */
    @Test
    public void testGetRoadWeight() {
        System.out.println("getRoadWeight");
        double expResult = 10.0;
        double result = bike.getRoadWeight();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of setMaxCapacity method, of class Bike.
     */
    @Test
    public void testSetMaxCapacity() {
        System.out.println("setMaxCapacity");
        String maxCapacity = "1000";
        bike.setMaxCapacity(maxCapacity);
    }

    @Test
    public void tesSetWeight() {
        System.out.println("setWeight");
        bike.setWeight(10);
    }

    @Test
    public void testGetWeight() {
        System.out.println("testGetWeight");
        int expResult = 10;
        int result = bike.getWeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDEFAULT_WEIGHT method, of class Bike.
     */
    @Test
    public void testGetDEFAULT_WEIGHT() {
        System.out.println("getDEFAULT_WEIGHT");
        int expResult = 10;
        int result = Bike.getDEFAULT_WEIGHT();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWeight method, of class Bike.
     */
    @Test
    public void testSetWeight() {
        System.out.println("setWeight");
        int weight = 20;
        Bike instance = bike;
        instance.setWeight(weight);
        int expResult = 20;
        int result = bike.getWeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMechanicalCoefficient method, of class Bike.
     */
    @Test
    public void testGetMechanicalCoefficient() {
        System.out.println("getMechanicalCoefficient");
        Bike instance = bike;
        double expResult = 1.1;
        double result = instance.getMechanicalCoefficient();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of setMechanicalCoefficient method, of class Bike.
     */
    @Test
    public void testSetMechanicalCoefficient() {
        System.out.println("setMechanicalCoefficient");
        double mechanicalCoefficient = 4.0;
        Bike instance = bike;
        instance.setMechanicalCoefficient(mechanicalCoefficient);
        double expResult = 4.0;
        double result = instance.getMechanicalCoefficient();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of getAerodynamicCoefficient method, of class Bike.
     */
    @Test
    public void testGetAerodynamicCoefficient() {
        System.out.println("getAerodynamicCoefficient");
        Bike instance = bike;
        double expResult = 2.2;
        double result = instance.getAerodynamicCoefficient();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of setAerodynamicCoefficient method, of class Bike.
     */
    @Test
    public void testSetAerodynamicCoefficient() {
        System.out.println("setAerodynamicCoefficient");
        double aerodynamicCoefficient = 3.3;
        Bike instance = bike;
        instance.setAerodynamicCoefficient(aerodynamicCoefficient);
        double expResult = 3.3;
        double result = instance.getAerodynamicCoefficient();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of getParkLongitude method, of class Bike.
     */
    @Test
    public void testGetParkLongitude() {
        System.out.println("getParkLongitude");
        Bike instance = bike;
        float expResult = 3.0F;
        float result = instance.getParkLongitude();
        assertEquals(expResult, result, 0.1);
    }

    @Test
    public void testGetArea() {
        System.out.println("getArea");
        Bike instance = bike;
        assertEquals(instance.getArea(), 1);

    }

    @Test
    public void testSetArea() {
        System.out.println("setArea");
        Bike instance = bike;
        instance.setArea(1);
        assertEquals(instance.getArea(),1);
    }

    /**
     * Test of setParkLongitude method, of class Bike.
     */
    @Test
    public void testSetParkLongitude() {
        System.out.println("setParkLongitude");
        float parkLongitude = 4.0F;
        Bike instance = bike;
        instance.setParkLongitude(parkLongitude);
        float expResult = 4.0F;
        float result = instance.getParkLongitude();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of getParkLatitude method, of class Bike.
     */
    @Test
    public void testGetParkLatitude() {
        System.out.println("getParkLatitude");
        Bike instance = bike;
        float expResult = 4.0F;
        float result = instance.getParkLatitude();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of setParkLatitude method, of class Bike.
     */
    @Test
    public void testSetParkLatitude() {
        System.out.println("setParkLatitude");
        float parkLatitude = 3.0F;
        Bike instance = bike;
        instance.setParkLatitude(parkLatitude);
        float expResult = 3.0F;
        float result = instance.getParkLatitude();
        assertEquals(expResult, result, 0.1);
    }

}
