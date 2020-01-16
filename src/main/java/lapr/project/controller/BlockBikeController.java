/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.Calendar;
import lapr.project.data.MonthlyTripsDB;
import lapr.project.data.TripDB;
import lapr.project.data.UserDB;
import lapr.project.model.MonthlyTrips;
import lapr.project.model.Park;
import lapr.project.model.Trip;
import lapr.project.model.User;
import lapr.project.utils.SendEmail;
import lapr.project.utils.Utils;


/**
 *
 * @author Filipa Pereira 1170657@isep.ipp.pt
 */
public class BlockBikeController {

    private final float contante1points = 25.0f;
    private final float contante2points = 50.0f;
    private final int points1 = 5;
    private final int points2 = 15;

    private Trip trip;

    public BlockBikeController() {
        this.trip = new Trip();
    }

    public Trip getTripNotBlocked(String username) {
        return trip.getTripNotBlocked(username);
    }
    
    public void lockBike(String idBike, double longitude, double latitude){
        Trip t = new Trip();
        t = t.getTripHavingBikeID(idBike);
        blockBike(t, longitude, latitude, idBike);
    }

    public void blockBike(Trip t, double longitude, double latitude, String idBike) {
        /*
        instancias
        */
        UserDB udb = new UserDB();
        MonthlyTripsDB mtdb = new MonthlyTripsDB();
        TripDB tdb = new TripDB();
        /*
        calcular diferenca de altitude
        */
        float originAlt = Park.getPark(t.getOrigin()).getAltitude();
        float destinationAlt = Park.getPark(t.getDestination()).getAltitude();
        float altFinal = destinationAlt - originAlt;
        /*
        Block the bike
        */
        t.blockBike(idBike);
        /*
        ADD POINTS
        Restrições para adicionar pontos
         */
        int receivedPoints = 0;
        String username = t.getUsername();
        if (contante1points <= altFinal && altFinal < contante2points) {
            udb.addUserPoints(username, points1);
            receivedPoints = points1;
        } else if (contante2points < altFinal) {
            udb.addUserPoints(username, points2);
            receivedPoints=points2;
        }
        /*
        UPDATE TRIP PRICE
         */
        float tripPrice = t.totalTripPrice(t.getIdTrip());
        tdb.updateTripPrice(t.getIdTrip(),tripPrice);
        /*
        Get the atual date
        */
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int mes = Calendar.getInstance().get(Calendar.MONTH);
        String data = mes+"_"+year;       
        /*
        UPDATE MONTHLYTRIPS TOTALPRICE
        */
        MonthlyTrips mt = new MonthlyTrips(0, t.getUsername(), data, tripPrice, receivedPoints);
        //vai procurar se existe alguma monthlytrip com aquele username e datemonthyear senão existir ele cria uma nova e com (0, t.getUsename, date_monthYear, t.getPrice())
        try {
            //vai ver se existe uma monthly trip com uma certa dateMonthYear e um certo usenrame
            MonthlyTrips mtExistente = new MonthlyTripsDB().getMonthlyTrips(t.getUsername(), data);
            //fazer update do precoTotal da monthlyTrip, precoTotal = precoTotal + precodatrip
            mtdb.updatePrice(mtExistente.getIdMonthlyTrip(), tripPrice);
            mtdb.updateMonthlyTripPoints(mtExistente.getIdMonthlyTrip(), receivedPoints);
        } catch (IllegalArgumentException ex) {
            //Of the record does not exist, save it
            new MonthlyTripsDB().addMonthlyTrip(mt);
        }
        
    }

    public Trip getTrip(int id) {
        return trip.getTrip(id);
    }

    public void sendEmail(Trip trip){
        Utils utils = new Utils();
        SendEmail s = new SendEmail();
        Trip t = getTrip(trip.getIdTrip());
        User temp = User.getUser(t.getUsername());
        String receiver = temp.getEmail();
        long hoursOfTrip = utils.hoursBetween(t.getDateTrip(), t.getDateEnd());
        String message = "Your bike has been successfuly blocked.\nYou used it for " + hoursOfTrip + " hours.\n";
        s.sendEmail(receiver, message);
    }

}
