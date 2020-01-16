/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import lapr.project.model.Invoice;
import lapr.project.model.MonthlyTrips;
import lapr.project.model.Receipt;
import lapr.project.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Diogo Rolo
 */
public class PaymentControllerTest {

    public PaymentControllerTest() {
    }

    /**
     * Test of getListMonthlyTripsController method, of class PaymentController.
     */
    @Test
    public void testGetListMonthlyTripsController() {
        System.out.println("getListMonthlyTripsController");
        String username = "Diogo";
        List<MonthlyTrips> expResult = new ArrayList<>();
        MonthlyTrips mt1 = new MonthlyTrips(1, "1_18", "Diogo", 30,0);
        MonthlyTrips mt2 = new MonthlyTrips(5, "2_18", "Diogo", 24,0);
        expResult.add(mt1);
        expResult.add(mt2);
        List<MonthlyTrips> result = PaymentController.getListMonthlyTrips(username);
        expResult.equals(result);
    }

    /**
     * Test of getMonthlyTripsController method, of class PaymentController.
     */
    @Test
    public void testGetMonthlyTripsController() {
        System.out.println("getMonthlyTripsController");
        String username = "Diogo";
        String date = "2_18";
        MonthlyTrips expResult = new MonthlyTrips(5, "2_18", "Diogo", 30,0);
        MonthlyTrips result = PaymentController.getMonthlyTrips(username, date);
        expResult.equals(result);
    }

    /**
     * Test of getIdMonthlyTrip method, of class PaymentController.
     */
    @Test
    public void testGetIdMonthlyTrip() {
        System.out.println("getIdMonthlyTrip");
        MonthlyTrips mt = new MonthlyTrips(5, "2_18", "Diogo", 24,0);
        int expResult = 5;
        int result = PaymentController.getIdMonthlyTrip(mt);
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdUser method, of class PaymentController.
     */
    @Test
    public void testGetIdUser() {
        System.out.println("getIdUser");
        User u = new User("João Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "User", 0, 10f);
        String expResult = "joaoMiguel96";
        String result = PaymentController.getUsernameUser(u);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeMothlyTripController method, of class PaymentController.
     */
//    @Test
//    public void testRemoveMothlyTripController() {
//        System.out.println("removeMothlyTripController");
//        int idMonthlyTrip = 0;
//        PaymentController.removeMothlyTripController(idMonthlyTrip);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of getDateController method, of class PaymentController.
     */
    @Test
    public void testGetDateController() {
        System.out.println("getDateController");
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int mes = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        String expResult = dia + "-" + mes + "-" + year;
        String result = PaymentController.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInvoiceStringController method, of class PaymentController.
     */
    @Test
    public void testGetInvoiceStringController() {
        System.out.println("getInvoiceStringController");
        Invoice inv = new Invoice("Diogo", "1_18", "2018-10-10", 100f);
        String expResult = "Invoice:\n"
                + "\n"
                + "IVA = 0.23\n"
                + "Username = Diogo\n"
                + "Mes_Ano = 1_18\n"
                + "Emmission Date = 2018-10-10\n"
                + "total a pagar = 100.0euros";
        String result = PaymentController.getInvoiceString(inv);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateMonthYearController method, of class PaymentController.
     */
    @Test
    public void testGetDateMonthYearController() {
        System.out.println("getDateMonthYearController");
        Invoice inv = new Invoice("Diogo", "1_18", "2018-10-10", 100f);
        String expResult = "1_18";
        String result = PaymentController.getDateMonthYear(inv);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateMonthYearMTController method, of class PaymentController.
     */
    @Test
    public void testGetDateMonthYearMTController() {
        System.out.println("getDateMonthYearMTController");
        MonthlyTrips mt = new MonthlyTrips(5, "2_18", "Diogo", 24,0);
        String expResult = "2_18";
        String result = PaymentController.getDateMonthYearMT(mt);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUserPoints method, of class PaymentController.
     */
    @Test
    public void testGetUserPoints() {
        System.out.println("getUserPoints");
        String username = "administrador";
        int expResult = 2;
        int result = PaymentController.getUserPoints(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of precoFinalComPontoseIvaController method, of class
     * PaymentController.
     */
    @Test
    public void testPrecoFinalComPontoseIvaController() {
        System.out.println("precoFinalComPontoseIvaController");
        Invoice inv = new Invoice("Diogo", "1_18", "2018-10-10", 100f);
        int points = 25;
        float expResult = 119.925f;
        float result = PaymentController.precoFinalComPontoseIva(inv, points);
        assertEquals(expResult, result);
        /*
        float descountPrice = pointsUser * pointsValue;
        total = total - descountPrice;
        return (IVA * total) + total;
         */
    }

    /**
     * Test of priceMonthlyTrip method, of class PaymentController.
     */
    @Test
    public void testPriceMonthlyTrip() {
        System.out.println("priceMonthlyTrip");
        MonthlyTrips mt = new MonthlyTrips(5, "2_18", "Diogo", 30,0);
        float expResult = 30.0f;
        float result = PaymentController.priceMonthlyTrip(mt);
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserPointsZero method, of class PaymentController.
     */
    @Test
    public void testSetUserPointsZero() {
        System.out.println("setUserPointsZero");
        String username = "Fabio";
        PaymentController.setUserPointsZero(username);
    }

    /**
     * Test of updateUserPoints method, of class PaymentController.
     */
    @Test
    public void testUpdateUserPoints() {
        System.out.println("updateUserPoints");
        String username = "Diogo";
        int nPointsRestantes = 10;
        PaymentController.updateUserPoints(username, nPointsRestantes);
    }

    /**
     * Test of totalPontosPodemSerUtilizados method, of class PaymentController.
     */
    @Test
    public void testTotalPontosPodemSerUtilizados() {

        System.out.println("totalPontosPodemSerUtilizados");
        int nPoints = 25;
        Invoice instance = new Invoice("Igor", "1_18", "2018-10-10", 1.5f);
        int expResult = 15;
        int result = PaymentController.totalPontosPodemSerUtilizados(instance, nPoints);
        assertEquals(expResult, result);

        System.out.println("totalPontosPodemSerUtilizados");
        int nPoints2 = 25;
        Invoice instance2 = new Invoice("Igor", "1_18", "2018-10-10", 2.5f);
        int expResult2 = 5;
        int result2 = PaymentController.totalPontosPodemSerUtilizados(instance2, nPoints2);
        assertEquals(expResult2, result2);

        System.out.println("totalPontosPodemSerUtilizados");
        int nPoints3 = 24;
        Invoice instance3 = new Invoice("Igor", "1_18", "2018-10-10", 2.5f);
        int expResult3 = 4;
        int result3 = PaymentController.totalPontosPodemSerUtilizados(instance3, nPoints3);
        assertEquals(expResult3, result3);
    }

    /**
     * Test of verificarSeExisteNaLista method, of class PaymentController.
     */
    @Test
    public void testVerificarSeExisteNaLista() {
        System.out.println("verificarSeExisteNaLista");
        List<MonthlyTrips> mtList = new ArrayList<>();
        String date = "2_18";
        int expResult = 0;
        MonthlyTrips mt = new MonthlyTrips(0, "1_18", "Bruno", 0,0);
        mtList.add(mt);
        int result = PaymentController.verificarSeExisteNaLista(mtList, date);
        assertEquals(expResult, result);

        List<MonthlyTrips> mtList1 = new ArrayList<>();
        String date1 = "2_18";
        int expResult1 = 1;
        MonthlyTrips mt1 = new MonthlyTrips(0, "2_18", "Bruno", 0,0);
        mtList1.add(mt1);
        int result1 = PaymentController.verificarSeExisteNaLista(mtList1, date1);
        assertEquals(expResult1, result1);
    }

    /**
     * Test of getReceiptStringController method, of class PaymentController.
     */
    @Test
    public void testGetReceiptStringController() {
        System.out.println("getReceiptStringController");
        Receipt re = new Receipt("Bro", "2_18", 22, 0.23f, 24.5f, 25);
        String expResult = "Receipt:\n"
                + "username --- Bro\n"
                + "Qty  1    dateMonthYear 2_18  ------- Total:22.0\n"
                + "			      ------- IVA:0.23\n"
                + "			      ------- Total final:24.5\n"
                + "Points used: 25\n"
                + "\n"
                + "Thank you for your purchase!";
        String result = PaymentController.getReceiptString(re);
        assertEquals(expResult, result);
    }

    /**
     * Test of getIvaController method, of class PaymentController.
     */
    @Test
    public void testGetIvaController() {
        System.out.println("getIvaController");
        Invoice inv = new Invoice("Diogo", "1_18", "2018-10-10", 100f);
        PaymentController instance = new PaymentController();
        float expResult = 0.23f;
        float result = instance.getIva(inv);
        assertEquals(expResult, result);
    }

    /**
     * Test of nPontosUtilizados method, of class PaymentController.
     */
    @Test
    public void testNPontosUtilizados() {
        System.out.println("nPontosUtilizados");
        int nPoints = 10;
        int nPontosRestantes = 5;
        int expResult = 5;
        int result = PaymentController.nPontosUtilizados(nPoints, nPontosRestantes);
        assertEquals(expResult, result);
    }
    

}
