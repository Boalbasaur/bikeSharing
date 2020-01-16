/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.Calendar;
import java.util.List;
import java.util.ListIterator;
import lapr.project.data.MonthlyTripsDB;
import lapr.project.data.UserDB;
import lapr.project.model.Invoice;
import lapr.project.model.MonthlyTrips;
import lapr.project.model.Receipt;
import lapr.project.model.User;

/**
 *
 * @author Diogo Rolo
 */
public final class PaymentController {
    
    
    private static Invoice inv;
    
    private static Receipt rec;
    
    public static Invoice returnInvoice(String u, MonthlyTrips mt, float preco){
     return new Invoice(u, getDateMonthYearMT(mt), getDate(), priceMonthlyTrip(mt));
    } 
    
    public static Receipt returnReceipt(String username, MonthlyTrips mt, Invoice inv, int nPoints){
     return new Receipt(username, getDateMonthYearMT(mt), priceMonthlyTrip(mt), inv.getIVA(), precoFinalComPontoseIva(inv, nPoints), nPoints);
    } 

    public static List<MonthlyTrips> getListMonthlyTrips(String username) {
        MonthlyTripsDB mtdb = new MonthlyTripsDB();
        return mtdb.getListMonthlyTrips(username);
    }
    
    public static int nPontosUtilizados(int nPoints, int nPontosRestantes){
        return nPoints - nPontosRestantes;
    }

    public static MonthlyTrips getMonthlyTrips(String username, String date) {
        MonthlyTripsDB mtdb = new MonthlyTripsDB();
        return mtdb.getMonthlyTrips(username, date);
    }

    public static int getIdMonthlyTrip(MonthlyTrips mt) {
        return mt.getIdMonthlyTrip();
    }

    public static String getUsernameUser(User u) {
        return u.getUsername();
    }

    public static void removeMothlyTrip(int idMonthlyTrip) {
        MonthlyTripsDB mtdb = new MonthlyTripsDB();
        mtdb.removeMothlyTrip(idMonthlyTrip);
    }

    public static String getDate() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int mes = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        return dia + "-" + mes + "-" + year;
    }

    public static String getInvoiceString(Invoice inv) {
        return inv.toString();
    }
    public static String getReceiptString(Receipt re) {
        return re.toString();
    }

    public static String getDateMonthYear(Invoice inv) {
        return inv.getDateMonthYear();
    }

    public static String getDateMonthYearMT(MonthlyTrips mt) {
        return mt.getDateMonthYear();
    }

    public static int getUserPoints(String username) {
        UserDB udb = new UserDB();
        User u = udb.getUser(username);
        return u.getPoints();
    }

    public static float precoFinalComPontoseIva(Invoice inv, int points) {
        return inv.precoFinalComPontoseIva(points);
    }

    public static int totalPontosPodemSerUtilizados(Invoice inv, int nPoints) {
        return inv.totalPontosPodemSerUtilizados(nPoints);
    }

    public static float priceMonthlyTrip(MonthlyTrips mt) {
        return mt.getTotalPrice();
    }

    public static void setUserPointsZero(String username) {
        int points = 0;
        UserDB udb = new UserDB();
        udb.setUserPointsZero(username, points);
    }
    
    public float getIva(Invoice inv){
        return inv.getIVA();
    }

    public static void updateUserPoints(String username, int nPointsRestantes) {
        UserDB udb = new UserDB();
        udb.updateUserPoints(username, nPointsRestantes);
    }
    /*
    Retorna 1 caso encontre a data dada na lista
    0 se não for encontrada
    */
    public static int verificarSeExisteNaLista(List<MonthlyTrips> mtList, String date) {
        ListIterator<MonthlyTrips> itr = mtList.listIterator();
        MonthlyTrips mt1;
        while(itr.hasNext()){
            mt1 = itr.next();
            if(mt1.getDateMonthYear().equals(date)){
                return 1;
            }
        }
        return 0;
    }

}
