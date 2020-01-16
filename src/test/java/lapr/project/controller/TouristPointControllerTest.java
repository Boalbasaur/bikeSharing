/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.TouristPoint;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Daniela Vinagreiro
 */
public class TouristPointControllerTest {

    private List<TouristPoint> listTouristPoint = new ArrayList<>();
    private final TouristPoint touristPoint1;
    private final TouristPoint touristPoint2;
    private final TouristPoint touristPoint3;
    private final TouristPoint touristPoint4;

    public TouristPointControllerTest() {
        touristPoint1 = new TouristPoint(1, "Aliados", 48.5f, 48.5f, 25f);
        touristPoint2 = new TouristPoint(2, "Marquês", 49.5f, 49.5f, 24f);
        touristPoint3 = new TouristPoint(3, "Torre dos Clérigos", 43.5f, 48.5f, 25f);
        touristPoint4 = new TouristPoint(4, "Piolho", 45.5f, 48.5f, 25f);

        listTouristPoint.add(touristPoint1);
        listTouristPoint.add(touristPoint2);
        listTouristPoint.add(touristPoint3);
        listTouristPoint.add(touristPoint4);

    }

    /**
     * Test of newTouristPoint method, of class TouristPointController.
     */
    @Test
    public void testNewTouristPoint() {
        boolean success = false;
        System.out.println("newTouristPoint");
        int idTouristPoint = 5;
        String name = "ISEP";
        float latitude = 48.3F;
        float longitude = 48.6F;
        float altitude = 11F;
        TouristPointController.newTouristPoint(idTouristPoint, name, latitude, longitude, altitude);
        listTouristPoint.add(new TouristPoint(idTouristPoint, name, latitude, longitude, altitude));
        for (TouristPoint touristPoint : listTouristPoint) {
            if (touristPoint.getIdTouristPoint() == idTouristPoint && touristPoint.getDescription().equals(name) && touristPoint.getLatitude() == latitude
                    && touristPoint.getLongitude() == longitude && touristPoint.getAltitude() == altitude) {
                success = true;
            }
        }
        boolean expResult = true;
        boolean result = success;
        assertEquals(expResult, result);

    }

    /**
     * Test of getTouristPoint method, of class TouristPointController.
     */
    @Test
    public void testGetTouristPoint() {
        System.out.println("getTouristPoint");
        int idTouristPoint = 1;
        TouristPoint expResult = new TouristPoint(1, "Torre dos Clérigos", 48.5f, 48.6f, 28.4f);
        TouristPoint result = CalculateCaloriesController.getTouristPoint(idTouristPoint);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteTouristPoint method, of class TouristPointController.
     */
    @Test
    public void testDeleteTouristPoint() {
        System.out.println("deleteTouristPoint");
        int idTouristPoint = 4;
        boolean remove = false;
        listTouristPoint.remove(touristPoint4);

        for (TouristPoint touristPoint : listTouristPoint) {
            if (touristPoint.getIdTouristPoint() != idTouristPoint) {
                remove = true;
            }
        }
        boolean expResult = remove;
        boolean result = true;
        assertEquals(expResult, result);
    }

}
