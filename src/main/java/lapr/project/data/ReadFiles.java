/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import lapr.project.data.BikeDB;
import lapr.project.data.UserDB;
import lapr.project.data.ParkDB;
import lapr.project.data.TouristPointDB;
import lapr.project.data.WindDB;
import lapr.project.model.Bike;
import lapr.project.model.Park;
import lapr.project.model.TouristPoint;
import lapr.project.model.User;
import lapr.project.model.Wind;

/**
 *
 * @author Daniela Vinagreiro
 */
public class ReadFiles {

    public static int readFileBicycles(String fileName) throws FileNotFoundException {

        Set<Bike> bikes = new HashSet<>();
        Scanner input = new Scanner(new FileReader(fileName));

        while (input.hasNext()) {
            String line = input.nextLine();
            String[] data = line.split(";");
            int i = data.length;
            String bikeDescription = data[0];
            int availability = 1;
            int weigth;
            String type = data[2];
            float parkLatitude;
            float parkLongitude;
            String maxBatteryCapacity;
            String actualBatteryCapacity;
            double aerodynamicCoefficient;
            double mechanicalCoefficient;
            double area;
            if (!checkBikeExistence(bikeDescription) && validateType(type) == true) {

                weigth = Integer.parseInt(data[1]);
                parkLatitude = Float.parseFloat(data[3]);
                parkLongitude = Float.parseFloat(data[4]);
                maxBatteryCapacity = data[5];
                actualBatteryCapacity = data[6];
                aerodynamicCoefficient = Double.parseDouble(data[7]);
                mechanicalCoefficient = Double.parseDouble(data[8]);
                area = Double.parseDouble(data[9]);

                Bike bike = new Bike(bikeDescription, type, availability, actualBatteryCapacity, maxBatteryCapacity, weigth, mechanicalCoefficient,
                        aerodynamicCoefficient, parkLongitude, parkLatitude, area);

                new BikeDB().addBike(bike);
                bikes.add(bike);
            }
        }
        input.close();
        System.out.println(bikes);
        System.out.println(bikes.size());
        return bikes.size();
    }

    public static boolean checkBikeExistence(String bikeDescription) {
        boolean result = true;
        try {
            new BikeDB().getBike(bikeDescription);
        } catch (IllegalArgumentException e) {
            //Of the record does not exist, save it
            result = false;
        }
        return result;
    }

    public static boolean validateType(String type) {

        return type.equalsIgnoreCase("eletric") || type.equalsIgnoreCase("road") || type.equalsIgnoreCase("mtb");
    }

    public static int readFileParks(String fileName) throws FileNotFoundException {

        Set<Park> parks = new HashSet<>();
        Scanner input = new Scanner(new FileReader(fileName));

        while (input.hasNext()) {
            String line = input.nextLine();
            String[] data = line.split(";");
            int idPark = new ParkDB().generateParkID();
            float latitude = Float.parseFloat(data[0]);
            float longitude = Float.parseFloat(data[1]);
            int elevation = 0;
            String parkDescription = "";
            int maxNumberEletricBycicle = 0;
            int maxNumberOfOtherBycicleTypes = 0;
            double parkInputVoltage = 0;
            double parkInputCurrent = 0;

            if (validateLocation(latitude, longitude) == 0) {

                if (data[2].isEmpty()) {
                    elevation = 0;
                } else {
                    elevation = Integer.parseInt(data[2]);
                }
                parkDescription = data[3];
                maxNumberEletricBycicle = Integer.parseInt(data[4]);
                maxNumberOfOtherBycicleTypes = Integer.parseInt(data[5]);
                parkInputVoltage = Double.parseDouble(data[6].substring(0, data[6].length()));
                parkInputCurrent = Double.parseDouble(data[7].substring(0, data[7].length()));
                Park park = new Park(idPark, parkDescription, latitude, longitude, maxNumberOfOtherBycicleTypes, maxNumberEletricBycicle,
                        elevation, parkInputVoltage, parkInputCurrent);
                new ParkDB().addPark(park);
                parks.add(park);
            }
        }
        input.close();
        return parks.size();
    }

    public static int validateLocation(float latitude, float longitude) {

        return new ParkDB().validateLocationPark(latitude, longitude);

    }

    public static int readFilePaths(String fileName) throws FileNotFoundException {

        Set<Wind> paths = new HashSet<>();
        Scanner input = new Scanner(new FileReader(fileName));
        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);
            String[] data = line.split(";");
            float latitudeA = Float.parseFloat(data[0]);
            float longitudeA = Float.parseFloat(data[1]);
            String origin = "";

            if (new ParkDB().validateLocationPark(longitudeA, latitudeA) == 1) {
                Park park = new ParkDB().getParkHavingCoordinates(longitudeA, latitudeA);
                origin = "Park_" + park.getIdPark();
            } else if (new TouristPointDB().validateLocationTouristPoint(latitudeA, longitudeA) == 1) {
                TouristPoint touristPoint = new TouristPointDB().getTouristPointHavingCoordinates(longitudeA, latitudeA);
                origin = "TouristPoint" + touristPoint.getIdTouristPoint();
            }

            float latitudeB = Float.parseFloat(data[2]);
            float longitudeB = Float.parseFloat(data[3]);
            String destination = "";

            if (new ParkDB().validateLocationPark(longitudeB, latitudeB) == 1) {
                Park park = new ParkDB().getParkHavingCoordinates(longitudeB, latitudeB);
                destination = "Park_" + park.getIdPark();
            } else if (new TouristPointDB().validateLocationTouristPoint(latitudeB, longitudeB) == 1) {
                TouristPoint touristPoint = new TouristPointDB().getTouristPointHavingCoordinates(longitudeB, latitudeB);
                destination = "TouristPoint_" + touristPoint.getIdTouristPoint();
            }
            String pathDirection = data[4];
            float friction;
            float windDirection; // crosswind
            double windSpeed;
            if (pathDirection.equalsIgnoreCase("bi") || pathDirection.equalsIgnoreCase("uni")) {
                if (data[5].equals(" ")) {
                    friction = 0;
                } else {
                    friction = Float.parseFloat(data[5]);
                }
                if (data[6].equals(" ")) {
                    windDirection = 0;
                } else {
                    windDirection = Float.parseFloat(data[6]); // crosswind
                }
                if (data[7].equals(" ")) {
                    windSpeed = 0;
                } else {
                    windSpeed = Double.parseDouble(data[7]);
                }
                Wind wind = new Wind(origin, destination, windSpeed, windDirection, friction);
                new WindDB().addWind(wind);
                paths.add(wind);
            }

        }
        input.close();
        return paths.size();
    }

    public static int readFileTouristPoint(String fileName) throws FileNotFoundException {

        Set<TouristPoint> tp = new HashSet<>();
        Scanner input = new Scanner(new FileReader(fileName));

        while (input.hasNext()) {
            String line = input.nextLine();
            String[] data = line.split(";");
            int idTouristPoint = 0;
            float latitude = Float.parseFloat(data[0]);
            float longitude = Float.parseFloat(data[1]);
            int elevation = 0;
            String touristPointDescription;
            if (validateLocationTouristPoint(latitude, longitude) == 0) {
                idTouristPoint = new TouristPointDB().generateTouristParkID();
                if (data[2].isEmpty()) {
                    elevation = 0;
                }
                touristPointDescription = data[3];

                TouristPoint touristPoint = new TouristPoint(idTouristPoint, touristPointDescription, latitude, longitude, elevation);
                new TouristPointDB().addTouristPoint(touristPoint);
                tp.add(touristPoint);
            }
        }
        input.close();
        return tp.size();
    }

    public static int validateLocationTouristPoint(float latitude, float longitude) {
        return new TouristPointDB().validateLocationTouristPoint(latitude, longitude);
    }

    public static int readFileUsers(String fileName) throws FileNotFoundException {

        Set<User> users = new HashSet<>();
        Scanner input = new Scanner(new FileReader(fileName));

        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] data = line.split(";");
            String name = "nameTest";
            String passAut = "qwerty";
            String username;
            String email = "";
            double weigth = 0;
            double heigth = 0;
            double averageSpeed = 0;
            String creditCardNumber = "";

            if (!validateUsername(data[0])) {
                username = data[0];
                email = data[1];
                heigth = Double.parseDouble(data[2]);
                weigth = Double.parseDouble(data[3]);
                averageSpeed = Double.parseDouble(data[4]);
                creditCardNumber = data[5];
                User user = new User(username, name, email, passAut, creditCardNumber, heigth, weigth, averageSpeed);
                new UserDB().addUser(user);
                users.add(user);
            }

        }
        input.close();
        return users.size();
    }

    public static boolean validateUsername(String username) {

        boolean result = false;
        try {
            new UserDB().getUser(username);
            result = true;
        } catch (IllegalArgumentException ex) {
            //Of the record does not exist, save it
            result = false;
        }
        return result;
    }
}
