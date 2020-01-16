package lapr.project.ui;

import lapr.project.data.DataHandler;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;
import lapr.project.adjacencyMap.Graph;
import lapr.project.controller.GraphController;
import lapr.project.model.PathInfo;
import static lapr.project.ui.LoginUI.loginUI;

/**
 * @author Nuno Bettencourt <nmb@isep.ipp.pt> on 24/05/16.
 */
class Main {

    /**
     * Logger class.
     */
    private static final Logger LOGGER = Logger.getLogger("MainLog");

    /**
     * Private constructor to hide implicit public one.
     */
    private Main() {

    }

    /**
     * Application main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException {
        //load database properties
        try {
            Properties properties
                    = new Properties(System.getProperties());
            InputStream input = new FileInputStream("target/classes/application.properties");
            properties.load(input);
            input.close();
            System.setProperties(properties);

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Graph<String, PathInfo> grafo;

        GraphController controller = new GraphController();
        
        grafo = controller.getGrafo();
        controller.fillGraph();
        controller.insertEdgesOnDB();

        //Initial Database Setup
        DataHandler dh = new DataHandler();
        String username = "";
        int op = 0;
        do {
            op = menuEnter();
            switch (op) {
                case 1:
                    username = "invalid";
                    while (username.equals("invalid")) {
                        username = loginUI();
                    }
                    break;
                case 2:
                    UserRegistrationUI.userRegistrationUI();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (op != 1);

        if (username.equalsIgnoreCase("administrador")) {

            do {
//                op = menuAdmin();
//                switch (op) {
//                    case 1:
//                        UpdateBikeUI.updateBicyclesUI();
//                        break;
//                    case 2:
//                        UpdateParkUI.updateParkUI();
//                        break;
//                    case 3:
//                        UpdateTouristPointUI.updateTouristPointUI();
//                        break;
//                    case 4:
//                        ParkReportUI.parkReportUI();
//                        break;
//                    case 5:
//                        break;
//                    default:
//                        System.out.println("Invalid option");
//                        break;
                op = menuTest();
                switch (op) {
                    case 1:
                        int bikes = Testing.addBicycles("bikes.csv");
                        System.out.println(bikes + " new bikes were added to the database!");
                        break;
                    case 2:
                        int parks = Testing.addParks("parks.csv");
                        System.out.println(parks + " new parks were added to the database!");
                        break;
                    case 3:
                        int pois = Testing.addPOIs("pois.csv");
                        System.out.println(pois + " new tourist points were added to the database!");
                        break;
                    case 4:
                        int users = Testing.addUsers("users.csv");
                        System.out.println(users + " new users were added to the database!");
                        break;
                    case 5:
                        int paths = Testing.addPaths("paths.csv");
                        System.out.println(paths + " new paths were added to the database!");
                        break;
                    case 6:
                        Testing.getNumberOfBicyclesAtPark(123, 123, "bicycle.csv");
                        break;
                    case 7:
                        int slots = Testing.getFreeSlotsAtPArk(123, 123, "Diogo");
                        System.out.println(slots + " free slots");
                        break;
                    case 8:
                        Testing.getNearestParks(456, 456, "nearparks.csv");
                        break;
                    case 9:
                        int distance = Testing.distanceTo(123, 123, 456, 456);
                        System.out.println("Distance: " + distance);
                        break;
                    case 10:
                        long time = Testing.unlockBicycle("1", "Daniela");
                        System.out.println(time);
                        break;
                    case 11:
                        long time2 = Testing.lockBicycle("4", 456, 456);
                        System.out.println(time2);
                        break;
                    case 12:
                        Testing.getUserCurrentDebt("Diogo", "invoice.csv");
                        break;
                    case 13:
                        Testing.getUserCurrentPoints("Diogo", "points.csv");
                        break;
                    case 14:
                        Testing.unlockAnyBicycleAtPark(456, 456, "Daniela", "unlock.csv");
                        break;
                    case 15:
                        Testing.unlockAnyElectricBicycleAtPark(456, 456, "Daniela", "unlockElectric.csv");
                        break;
                    case 16:
                        Testing.calculateElectricalEnergyToTravelFromOneLocationToAnother(123, 123, 456, 456, "Diogo");
                        break;
                    case 17:
                        Testing.suggestElectricalBicyclesToGoFromOneParkToAnother(123, 123, 456, 456, "Diogo", "routes.csv");
                        break;
                    case 18:
                        Testing.forHowLongWasTheBicycleUnlocked("2");
                        break;
                    case 19:
                        Testing.shortestRouteBetweenTwoParks(456, 456, 123, 123, "shortestroute.csv");
                        break;
                    case 20:
                        Testing.mostEnergyEfficientRouteBetweenTwoParks(123, 123, 456, 456, "road", "Daniela", "energyefficient.csv");
                        break;
                    case 21:
                        Testing.shortestRouteBetweenTwoParksForGivenPOIs(456, 456, 123, 123, "points.csv", "shortroute.csv");
                        break;
                    case 22:
                        Testing.getParkChargingReportForPark(123, 123, "report.csv");
                        break;
                    case 23:
                        Testing.suggestRoutesBetweenTwoLocations(op, op, op, op, username, username, op, true, username, username, username); //prov
                        break;
                    case 24:
                        Testing.getInvoiceForMonth(2, "Diogo", "invoicemonth.csv");
                        break;
                    case 25:
                        break;
                }
            } while (op != 25);
        } else {
            do {
                op = menuUser();
                switch (op) {
                    case 1:
                        FreeParkingSpotsUI.freeParkingSpots(username);
                        break;
                    case 2:
                        NearestParksUI.nearestParkUI();
                        break;
                    case 3:
                        CalculateCaloriesUI.calculateCaloriesUI(username, grafo);
                        break;
                    case 4:
                        AvailableBicyclesUI.availableBicyclesUI();
                        break;
                    case 5:
                        DistanceToParkUI d = new DistanceToParkUI();
                        d.distanceToPark(username);
                        break;
                    case 6:
                        AssignBikeToUserUI.AssignBikeToUserUI(grafo);
                        break;
                    case 7:
                        BlockBikeUI b = new BlockBikeUI();
                        b.blockBike(username);
                        break;
                    case 8:
                        PaymentUI.paymentUI(username);
                        break;
                    case 9:
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            } while (op != 9);
        }
    }

    public static int menuEnter() {
        Scanner in = new Scanner(System.in);
        System.out.printf("\nMenu \n(1) Login \n(2) Create account \nChoose your option: ");
        int op = in.nextInt();
        in.nextLine();
        return op;
    }

    public static int menuUser() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nMenu \n(1) Check free parking spots \n(2) See nearest parks \n"
                + "(3) See burnt calories projection \n(4) Check for available bikes \n"
                + "(5) See distance between parks \n(6) Unlock bike \n(7) Block bike \n"
                + "(8) Payments\n(9) Exit\nChoose your option: ");
        int op = in.nextInt();
        in.nextLine();
        return op;
    }

    public static int menuAdmin() {
        Scanner in = new Scanner(System.in);
        System.out.printf("\nMenu \n(1) Add/Update/Remove bike \n(2) Add/Update/Remove park \n"
                + "(3) Add/Update/Remove tourist point \n(4) Get report of a park \n"
                + "(5) Exit \nChoose your option: ");
        int op = in.nextInt();
        in.nextLine();
        return op;
    }
    
    public static int menuTest() {
        Scanner in = new Scanner(System.in);
        System.out.println("\n(1) addBicycles \n(2) addParks \n(3) addPOIs \n(4) addUsers \n"
                + "(5) addPaths \n(6) getNumberOfBicyclesAtPark \n(7) getFreeSlotsAtPArk \n"
                + "(8) getNearestParks \n(9) distanceTo \n(10) unlockBicycle \n(11) lockBicycle \n"
                + "(12) getUserCurrentDebt \n(13) getUserCurrentPoints \n(14) unlockAnyBicycleAtPark \n"
                + "(15) unlockAnyElectricBicycleAtPark \n(16) calculateElectricalEnergyToTravelFromOneLocationToAnother \n"
                + "(17) suggestElectricalBicyclesToGoFromOneParkToAnother \n"
                + "(18) forHowLongWasTheBicycleUnlocked \n(19) shortestRouteBetweenTwoParks \n"
                + "(20) mostEnergyEfficientRouteBetweenTwoParks \n(21) shortestRouteBetweenTwoParksForGivenPOIs \n"
                + "(22) getParkChargingReportForPark \n(23) suggestRoutesBetweenTwoLocations \n"
                + "(24) getInvoiceForMonth \n");
        int op = in.nextInt();
        in.nextLine();
        return op;
    }
}
