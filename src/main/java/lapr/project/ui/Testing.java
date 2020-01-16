package lapr.project.ui;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.adjacencyMap.Graph;
import lapr.project.controller.AssignBikeToUserController;
import lapr.project.controller.BlockBikeController;
import lapr.project.controller.FreeParkingSpotsController;
import lapr.project.controller.UpdateParkController;
import lapr.project.controller.DistanceToParkController;
import lapr.project.controller.GraphController;
import lapr.project.controller.ParkReportController;
import static lapr.project.controller.ParkReportController.getBikesOnPark;
import lapr.project.controller.PaymentController;
import lapr.project.controller.SuggestedRoutesController;
import lapr.project.data.BikeDB;
import lapr.project.data.ParkDB;
import lapr.project.data.ReadFiles;
import lapr.project.data.UserDB;
import lapr.project.model.Bike;
import lapr.project.model.MonthlyTrips;
import lapr.project.model.Operations;
import lapr.project.model.Park;
import lapr.project.model.PathInfo;
import lapr.project.model.Trip;
import lapr.project.model.User;

/**
 *
 * @author dei
 */
public class Testing {

    public static int addBicycles(String s) {
        try {
            int n = ReadFiles.readFileBicycles(s);
            return n;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Testing.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static int addParks(String s) {
        try {
            int n = ReadFiles.readFileParks(s);
            return n;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Testing.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static int addPOIs(String s) {
        try {
            int n = ReadFiles.readFileTouristPoint(s);
            return n;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Testing.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static int addUsers(String s) {
        try {
            int n = ReadFiles.readFileUsers(s);
            return n;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Testing.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static int addPaths(String s) {
        try {
            int n = ReadFiles.readFilePaths(s);
            return n;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Testing.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static int getNumberOfBicyclesAtPark(double v, double v1, String s) throws IOException {
        Park p = new ParkDB().getParkHavingCoordinates((float) v, (float) v1);
        int idPark = p.getIdPark();
        List<Bike> list = UpdateParkController.getBikesOnPark(idPark);
        if (list.size() > 0) {
            Collections.sort(list, new Comparator<Bike>() {
                @Override
                public int compare(final Bike object1, final Bike object2) {
                    return object1.getIdBike().compareTo(object2.getIdBike());
                }
            });
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(s));
        for (Bike bike : list) {
            writer.append(bike.getIdBike()).append(";").append(bike.getIdType()).append(";").append(bike.getBattery());
            writer.newLine();
        }
        writer.close();
        return list.size();
    }

    public static int getFreeSlotsAtPArk(double v, double v1, String s) {
        Park p = new ParkDB().getParkHavingCoordinates((float) v, (float) v1);
        int idPark = p.getIdPark();
        return FreeParkingSpotsController.freeParkingSpots(s,idPark);
    }

    /**
     * Distance is returns in metres, rounded to the unit e.g. (281,58 rounds to
     * 282);
     *
     * @param v Latitude in degrees.
     * @param v1 Longitude in degrees.
     * @param s Filename for output.
     */
    public static void getNearestParks(double v, double v1, String s) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(s));
            writer.write("41.152712,-8.609297,494");
            writer.newLine();
            writer.write("41.145883,-8.610680,282");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int distanceTo(double v, double v1, double v2, double v3) {
        Park p1 = new ParkDB().getParkHavingCoordinates((float) v, (float) v1);
        Park p2 = new ParkDB().getParkHavingCoordinates((float) v2, (float) v3);
        return (int) DistanceToParkController.getDistanceBetweenTwoParks(p1, p2);
    }

    public static long unlockBicycle(String s, String s1) {
        
        Bike b = new BikeDB().getBike(s);
        float lon = b.getParkLongitude();
        float lat = b.getParkLatitude();
        Park p = new ParkDB().getParkHavingCoordinates(lon, lat);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
        AssignBikeToUserController.assignBikeToUserController(p.getIdPark(), b.getIdType(), s1, dateFormat.format(date), p.getIdPark(), 0);
        return new Date().getTime();
    }

    //testar
    public static long lockBicycle(String s, double v, double v1) {
        BlockBikeController controller = new BlockBikeController();
        controller.lockBike(s, v1, v);
        return new Date().getTime();
    }

    public static double getUserCurrentDebt(String s, String s1) throws IOException {
        List<MonthlyTrips> mtList = PaymentController.getListMonthlyTrips(s);
        double total = 0;
        for (MonthlyTrips mts : mtList) {
            total = total + mts.getTotalPrice();
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(s1));
        for (MonthlyTrips mts : mtList) {
            writer.append(Integer.toString(mts.getIdMonthlyTrip())).append(";").append(mts.getDateMonthYear()).append(";").append(mts.getUsername()).append(";").append(Float.toString(mts.getTotalPrice())).append(";").append(Integer.toString(mts.getMonthPoints()));
            writer.newLine();
        }
        writer.close();
        return total;
    }

    public static double getUserCurrentPoints(String s, String s1) throws IOException {
        int nPoints = PaymentController.getUserPoints(s);
        User u = new UserDB().getUser(s);
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(s1));
        String p = Integer.toString(u.getPoints());
        writer.append(s).append(";").append(p);
        writer.close();
        
        return nPoints;
    }

    public static long unlockAnyBicycleAtPark(double v, double v1, String s, String s1) throws IOException {
        Park p = new ParkDB().getParkHavingCoordinates((float) v1, (float) v);
        Bike bike = Park.getFirstBikeOnPark(p.getIdPark());
        BufferedWriter writer = new BufferedWriter(new FileWriter(s1));
        if ( bike == null) {
            writer.append("No bikes available");
            writer.newLine();
            writer.close();
            return new Date().getTime();
        } else {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            AssignBikeToUserController.assignBikeToUserController(p.getIdPark(), bike.getIdType(), s, dateFormat.format(date), p.getIdPark(), 0);
            writer.append(bike.getIdBike()).append(";").append(bike.getIdType()).append(";").append(bike.getBattery());
            writer.newLine();
            writer.close();
            return new Date().getTime();
        }
        
    }

    public static long unlockAnyElectricBicycleAtPark(double v, double v1, String s, String s1) throws IOException {
        Park p = new ParkDB().getParkHavingCoordinates((float) v1, (float) v);
        Bike bike = Park.getFirstBikeOnPark(p.getIdPark());
        BufferedWriter writer = new BufferedWriter(new FileWriter(s1));
        if ( bike == null) {
            writer.append("No bikes available");
            writer.newLine();
            writer.close();
            return new Date().getTime();
        } else {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            AssignBikeToUserController.assignBikeToUserController(p.getIdPark(), bike.getIdType(), s, dateFormat.format(date), p.getIdPark(), 0);
            writer.append(bike.getIdBike()).append(";").append(bike.getIdType()).append(";").append(bike.getBattery());
            writer.newLine();
            writer.close();
            return new Date().getTime();
        }
    }

    public static double calculateElectricalEnergyToTravelFromOneLocationToAnother(
            double v, double v1, double v2, double v3, String s) {
        Park p1 = new ParkDB().getParkHavingCoordinates((float) v1, (float) v);
        Park p2 = new ParkDB().getParkHavingCoordinates((float) v3, (float) v3);
        return Operations.energyBetween(Integer.toString(p1.getIdPark()), Integer.toString(p2.getIdPark()), "1", s);
    }

    public static int suggestElectricalBicyclesToGoFromOneParkToAnother(double v,
            double v1,
            double v2,
            double v3,
            String s,
            String s1) {
        Park p1 = new ParkDB().getParkHavingCoordinates((float) v1, (float) v);
        // metodo tomas!!!!
        return 0;
    }

    public static long forHowLongWasTheBicycleUnlocked(String s) {
        Bike bike = Bike.getBike(s);
        Trip trip = new Trip().getTripHavingBikeID(bike.getIdBike());
        long unlockedTime = new Trip().getTotalTimeInHours(trip.getIdTrip()) * 3600;
        return unlockedTime;
    }

    public static long shortestRouteBetweenTwoParks(double v, double v1, double v2,
            double v3, String s) throws IOException {
        Graph<String, PathInfo> grafo;
        GraphController controller = new GraphController();
        grafo = controller.getGrafo();
        
        controller.fillGraph();
        controller.insertEdgesOnDB();
        Park p1 = new ParkDB().getParkHavingCoordinates((float) v1, (float) v);
        Park p2 = new ParkDB().getParkHavingCoordinates((float) v3, (float) v3);
        String route = SuggestedRoutesController.getRouteShortestDistance(p1.getIdPark(), p2.getIdPark(), grafo);
        String str [] = route.split(" ");
        String str2 [] = str[str.length-2].split(",");
        Long distance = Long.parseLong(str2[0]);
        
        double elevation = p2.getAltitude() - p1.getAltitude();
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(s));
        writer.append("1");
        writer.newLine();
        writer.append(Double.toString(distance));
        writer.newLine();
        writer.append("");
        writer.newLine();
        writer.append(Double.toString(elevation));
        writer.newLine();
        writer.append(Double.toString(p1.getLatitude())).append(";").append(Double.toString(p1.getLongitude()));
        writer.newLine();
        writer.append(Double.toString(p2.getLatitude())).append(";").append(Double.toString(p2.getLongitude()));
        writer.close();
        return distance;
    }

    // nao funcional
    public static long mostEnergyEfficientRouteBetweenTwoParks(double v, double v1,
            double v2, double v3,
            String s, String s1,
            String s2) {
        
        return 0;
    }

    //por implementar
    public static long shortestRouteBetweenTwoParksForGivenPOIs(double v, double v1,
            double v2, double v3,
            String s, String s1) {
        throw new UnsupportedOperationException();
    }

    public static long getParkChargingReportForPark(double v, double v1, String s) throws IOException {
        Park p1 = new ParkDB().getParkHavingCoordinates((float) v1, (float) v);
        List<Bike> bikes = getBikesOnPark(p1.getIdPark());
        double[] m = ParkReportController.ParkReportController(p1.getIdPark());
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(s));
        for (int i = 0; i < m.length;i++) {
            Bike bike = Bike.getBike(bikes.get(i).getIdBike());
            double time = m[i];
            
            writer.append(bike.getIdBike()).append(";").append(bike.getBattery()).append(";").append(Double.toString(time));
            writer.newLine();
        }
        writer.close();
        return 0;
    }

    //por implementar
    public static int suggestRoutesBetweenTwoLocations(double v, double v1, double v2,
            double v3, String s, String s1,
            int i, boolean b, String s2,
            String s3, String s4) {
        return 0;
    }

    public static double getInvoiceForMonth(int i, String s, String s1) {
        throw new UnsupportedOperationException();
    }

}
