/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;


import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Fabio Santos
 */
public class ParkTest {
    private Park park;
    private Bike b;
    
    public ParkTest() {
        park = new Park(1, "name", 20f, 30f, 2, 2, 1,0,0);
        b = new Bike("2", "road",1, 10 ,1.1, 2.2 ,3f ,4f,1);
    }
  
    /**
     * Test of getBikes method, of class Park.
     */
    @Test
    public void testGetBikes() {
        System.out.println("getBikes");
        
       // park.addBike(2, 1, "18.12.16 04:15:32,653787000");
        List<Bike> b =Park.getBikes(1);
        assertEquals("1", b.get(0).getIdBike());
        
    }


    /**
     * Test of getId_park method, of class Park.
     */
    @Test
    public void testGetId_park() {
        System.out.println("getId_park");
      
        int expResult = 1;
        int result = park.getIdPark();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getName method, of class Park.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
      
        String expResult = "name";
        String result = park.getName();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getNormalSlots method, of class Park.
     */
    @Test
    public void testGetNormalSlots() {
        System.out.println("getNormalSlots");
        
        int expResult = 2;
        int result = park.getNormalSlots();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getEletricSlots method, of class Park.
     */
    @Test
    public void testGetEletricSlots() {
        System.out.println("getEletricSlots");
        
        int expResult = 2;
        int result = park.getEletricSlots();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setId_park method, of class Park.
     */
    @Test
    public void testSetId_park() {
        System.out.println("setId_park");
        int id_park = 1;
        
        park.setIdPark(id_park);
        
    }

    /**
     * Test of setName method, of class Park.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "name";
        
        park.setName(name);
        
    }

    /**
     * Test of setNormalSlots method, of class Park.
     */
    @Test
    public void testSetNormalSlots() {
        System.out.println("setNormalSlots");
        int normalSlots = 2;
        
        park.setNormalSlots(normalSlots);

    }

    /**
     * Test of setEletricSlots method, of class Park.
     */
    @Test
    public void testSetEletricSlots() {
        System.out.println("setEletricSlots");
        int eletricSlots = 2;
        
        park.setEletricSlots(eletricSlots);
        
    }

    /**
     * Test of getAltitude method, of class Park.
     */
    @Test
    public void testGetAltitude() {
        System.out.println("getAltitude");
        
        float expResult = 1;
        float result = park.getAltitude();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setAltitude method, of class Park.
     */
    @Test
    public void testSetAltitude() {
        System.out.println("setAltitude");
        float altitude = 1;
        
        park.setAltitude(altitude);
       
    }
    
    @Test
    public void testMaxBike(){
        System.out.println("getMaxBike");
        String id = Park.getMaxBike(1);
        assertEquals(id,"5");
    }
    
    /**
     * Test of getDistanceBetweenTwoParks method, of class Park.
     */
    @Test
    public void testGetDistanceBetweenTwoParks() {
        System.out.println("getDistanceBetweenTwoParks");
        Park toCheck = new Park(1, "name", 20f, 30f, 22, 2, 1, 12, 10);
        Park userPark = new Park(2, "name", 20f, 30f, 22, 2, 1, 12, 10);
        double expResult = 0;
        double result = Park.getDistanceBetweenTwoParks(toCheck, userPark);
        assertEquals(expResult, result);
    }

    /**
     * Test of getChargingSpeed method, of class Park.
     */
    @Test
    public void testGetChargingSpeed() {
        System.out.println("getChargingSpeed");
        Park instance = new Park(1, "name", 20f, 30f, 22, 2, 1, 12, 10);;
        double expResult = 0.06;
        double result = instance.getChargingSpeed();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVoltage method, of class Park.
     */
    @Test
    public void testGetVoltage() {
        System.out.println("getVoltage");
        Park instance = new Park(1, "name", 20f, 30f, 22, 2, 1, 12, 10);
        double expResult = 12;
        double result = instance.getVoltage();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrent method, of class Park.
     */
    @Test
    public void testGetCurrent() {
        System.out.println("getCurrent");
        Park instance = new Park(1, "name", 20f, 30f, 22, 2, 1, 12, 10);;
        double expResult =10;
        double result = instance.getCurrent();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdPark method, of class Park.
     */
    @Test
    public void testGetIdPark() {
        System.out.println("getIdPark");
        Park instance = new Park(1, "name", 20f, 30f, 22, 2, 1, 12, 10);;
        int expResult = 1;
        int result = instance.getIdPark();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLongitude method, of class Park.
     */
    @Test
    public void testGetLongitude() {
        System.out.println("getLongitude");
        Park instance = new Park(1, "name", 20f, 30f, 22, 2, 1, 12, 10);;
        float expResult = 20f;
        float result = instance.getLongitude();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLatitude method, of class Park.
     */
    @Test
    public void testGetLatitude() {
        System.out.println("getLatitude");
        Park instance = new Park(1, "name", 20f, 30f, 22, 2, 1, 12, 10);;
        float expResult = 30f;
        float result = instance.getLatitude();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdPark method, of class Park.
     */
    @Test
    public void testSetIdPark() {
        System.out.println("setIdPark");
        int idPark = 2;
        Park instance = new Park(1, "name", 20f, 30f, 22, 2, 1, 12, 10);;
        instance.setIdPark(idPark);
    }

    /**
     * Test of setLongitude method, of class Park.
     */
    @Test
    public void testSetLongitude() {
        System.out.println("setLongitude");
        float longitude = 0.0F;
        Park instance = new Park(1, "name", 20f, 30f, 22, 2, 1, 12, 10);;
        instance.setLongitude(longitude);
    }

    /**
     * Test of setLatitude method, of class Park.
     */
    @Test
    public void testSetLatitude() {
        System.out.println("setLatitude");
        float latitude = 0.0F;
        Park instance = new Park(1, "name", 20f, 30f, 22, 2, 1, 12, 10);
        instance.setLatitude(latitude);
    }

    /**
     * Test of setVoltage method, of class Park.
     */
    @Test
    public void testSetVoltage() {
        System.out.println("setVoltage");
        double voltage = 0.0;
        Park instance = new Park(1, "name", 20f, 30f, 22, 2, 1, 12, 10);;
        instance.setVoltage(voltage);
    }

    /**
     * Test of setCurrent method, of class Park.
     */
    @Test
    public void testSetCurrent() {
        System.out.println("setCurrent");
        double current = 0.0;
        Park instance = new Park(1, "name", 20f, 30f, 22, 2, 1, 12, 10);;
        instance.setCurrent(current);
    }

    /**
     * Test of getFirstBikeOnPark method, of class Park.
     */
    @Test
    public void testGetFirstBikeOnPark() {
        System.out.println("getFirstBikeOnPark");
        int idPark = 1;
        Bike expResult = new Bike("1", "road", 1, null, null, 7, 3, 4, 123, 123, 1);
        Bike result = Park.getFirstBikeOnPark(idPark);
        assertEquals(expResult.getIdBike(), result.getIdBike());
    }

    /**
     * Test of getFirstEltricalBikeMaxEnergy method, of class Park.
     */
    @Test
    public void testGetFirstEltricalBikeMaxEnergy() {
        System.out.println("getFirstEltricalBikeMaxEnergy");
        int idPark = 3;
        String expResult = "4";
        String result = Park.getFirstEltricalBikeMaxEnergy(idPark);
        assertEquals(expResult, result);
    }

   
    
}
