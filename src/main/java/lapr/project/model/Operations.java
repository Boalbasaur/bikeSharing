package lapr.project.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lapr.project.data.WindDB;

/**
 *
 * @author Diogo Rolo
 */
public class Operations {

    private static final int NPARQUELISTADOS = 5;
    private static final double K1MOUNTAIN = 7.845;
    private static final double K1ROAD = 3.509;
    private static final double K2MOUNTAIN = 0.3872;
    private static final double K2ROAD = 0.2581;

    private static final double DENSITY = 1.2922;

    //recebe como parametro um objeto do tipo LocalizacaoAtual ou recebe a longitude e latitude em separado?
    /**
     * Retorna a lista de n parques mais proximos Recebe como parametro as
     * coordenadas atuais e o registo de todos os parques
     *
     * @param lon
     * @param lat
     * @param alt
     * @param rp
     * @return
     */
    public List<Park> nearestBicycleParks(float lon, float lat, float alt, List<Park> rp) {
        ArrayList<Park> listaParquesMaisProximos = new ArrayList<>();
        HashMap<Park, Double> distParqueList = new HashMap<>();
        for (Park p : rp) {

            float lon1 = p.getLongitude();
            float lat1 = p.getLatitude();
            float alt1 = p.getAltitude();
            double dist = distanceCalculator(lon1, lat1, alt1, lon, lat, alt);
            distParqueList.put(p, dist);
        }
        for (int i = 0; i < NPARQUELISTADOS; i++) {
            double dMenor = Double.MAX_VALUE;
            Park aux;
            Park pmenor = (Park) distParqueList.keySet().toArray()[0];
            for (Map.Entry<Park, Double> p : distParqueList.entrySet()) {
                aux=p.getKey();
                double distAtual = distParqueList.get(aux);
                if (distAtual < dMenor) {
                    dMenor = distAtual;
                    pmenor = aux;
                }
            }
            listaParquesMaisProximos.add(pmenor);
            distParqueList.remove(pmenor);
            if (distParqueList.isEmpty()) {
                return listaParquesMaisProximos;
            }
        }
        return listaParquesMaisProximos;
    }

    /**
     * Calcula a distância entre 2 pontos recebendo como parametros
     * altitude,longitude e latitude de cada ponto
     *
     * @param lon1
     * @param lat1
     * @param altitudeAtual
     * @param lon2
     * @param lat2
     * @param altitudeParque
     * @return
     */
    public static double distanceCalculator(float lon1, float lat1, float altitudeParque, float lon2, float lat2, float altitudeAtual) {
        double theta = lon1 - lon2;
        double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;   // unit in Kilometers
        double altFinal = altitudeAtual - altitudeParque;
        altFinal = altFinal * 1.609344; // km
        double dist1 = Math.pow(dist, 2);         //
        altFinal = Math.pow(altFinal, 2);         //   teorema de pitagoras
        double distFinal = altFinal + dist1;      //
        return (Math.sqrt(distFinal));
    }

    public static double caloriesCalculater(float latitudeOrigin, float longitudeOrigin, float altitudeOrigin, float latitudeDestiny, float longitudeDestiny,
            float altitudeDestiny, int duration, User user, String bikeType, double bikeWeight, Wind wind) {

        float slope = (altitudeDestiny - altitudeOrigin) * 100;

        float crosswind = wind.getCrosswind();
        double windspeed = wind.getWindspeed();

        double cw = calculateWindDirectionRelatedToTheRoute(crosswind, windspeed, latitudeOrigin, longitudeOrigin, latitudeDestiny, longitudeDestiny);

        double totalKm = distanceCalculator(longitudeOrigin, latitudeOrigin, altitudeOrigin, longitudeDestiny, latitudeDestiny, altitudeDestiny);

        double cv = (totalKm * 1000) / duration; // speed of the cyclist in m/s

        double wEnergy;

        if ("mtb".equalsIgnoreCase(bikeType)) {
            double em = user.getWeight() + bikeWeight;
            wEnergy = cv * (K1MOUNTAIN + (K2MOUNTAIN * (cv + cw) * (cv + cw)) + (10.32 * em * (slope / 100)));
        } else{
            double em = user.getWeight() + bikeWeight; // mass of cyclist and bicycle in kg
            wEnergy = cv * (K1ROAD + (K2ROAD * (cv + cw) * (cv + cw)) + (10.32 * em * (slope / 100)));
        }

        double calories = convertWtoCalories(wEnergy);
        double totalCalories;
        if ("eletric".equalsIgnoreCase(bikeType)) {
            totalCalories = calories * duration * 0.30;
        } else {
            totalCalories = calories * duration;
        }
        return totalCalories;
    }

    public static double convertWtoCalories(double w) {
        return (w * 1000) / 69.78;
    }

    public static boolean enoughBattery(int idPark, int idPark1, String idBike, String username) {
        boolean i = false;
        Bike a = Bike.getBike(idBike);
        double energy = energyBetween("Park_" + idPark, "Park_" + idPark1, idBike, username);
        int battery = Integer.parseInt(a.getBattery());
        int maxCap = Integer.parseInt(a.getMaxCapacity());
        int max = (maxCap * battery / 100) * 3600000;
        if (energy * 1.10 < max) {
            i = true;
        }
        return i;
    }

    public static double energyBetween(String idPark, String idPark1, String idBike, String username) {
        String[] data = idPark.split("_");
        String[] data1 = idPark1.split("_");
        double distance = 0;
        double altitude = 0;
        Wind d = null;
        double windSpeed = 0;
        float windDirection = 0;
        Bike bike = Bike.getBike(idBike);
        User user = User.getUser(username);
        String pString = "Park";
        String ptString = "TouristPoint";
        if (data[0].equals(pString) && data1[0].equals(pString)) {
            Park p1 = Park.getPark(Integer.parseInt(data[1]));

            Park p2 = Park.getPark(Integer.parseInt(data1[1]));

            
            distance = Operations.distanceCalculator(p1.getLongitude(), p1.getLatitude(), p1.getAltitude(), p2.getLongitude(), p2.getLatitude(), p2.getAltitude());

            altitude = p2.getAltitude() - p1.getAltitude();
            d = new WindDB().getWind(idPark, idPark1);
            windDirection = d.getCrosswind();
            windSpeed = calculateWindDirectionRelatedToTheRoute(windDirection, d.getWindspeed(), p1.getLatitude(), p1.getLongitude(), p2.getLatitude(), p2.getLongitude());
        } else if (data[0].equals(ptString) && data1[0].equals(pString)) {
            Park p1 = Park.getPark(Integer.parseInt(data[1]));

            TouristPoint p2 = TouristPoint.getTouristPoint(Integer.parseInt(data1[1]));

           
            distance = Operations.distanceCalculator(p1.getLongitude(), p1.getLatitude(), p1.getAltitude(), p2.getLongitude(), p2.getLatitude(), p2.getAltitude());

            altitude = p2.getAltitude() - p1.getAltitude();
            d = new WindDB().getWind(idPark, idPark1);
            windDirection = d.getCrosswind();
            windSpeed = calculateWindDirectionRelatedToTheRoute(windDirection, d.getWindspeed(), p1.getLatitude(), p1.getLongitude(), p2.getLatitude(), p2.getLongitude());
        } else if (data[0].equals(pString) && data1[0].equals(ptString)) {
            Park p2 = Park.getPark(Integer.parseInt(data[1]));

            TouristPoint p1 = TouristPoint.getTouristPoint(Integer.parseInt(data1[1]));

           
            distance = Operations.distanceCalculator(p1.getLongitude(), p1.getLatitude(), p1.getAltitude(), p2.getLongitude(), p2.getLatitude(), p2.getAltitude());

            altitude = p2.getAltitude() - p1.getAltitude();
            d = new WindDB().getWind(idPark, idPark1);
            windDirection = d.getCrosswind();
            windSpeed = calculateWindDirectionRelatedToTheRoute(windDirection, d.getWindspeed(), p1.getLatitude(), p1.getLongitude(), p2.getLatitude(), p2.getLongitude());
        } else if (data[0].equals(ptString) && data1[0].equals(ptString)) {
            TouristPoint p1 = TouristPoint.getTouristPoint(Integer.parseInt(data[1]));

            TouristPoint p2 = TouristPoint.getTouristPoint(Integer.parseInt(data1[1]));

           
            distance = Operations.distanceCalculator(p1.getLongitude(), p1.getLatitude(), p1.getAltitude(), p2.getLongitude(), p2.getLatitude(), p2.getAltitude());

            altitude = p2.getAltitude() - p1.getAltitude();
            d = new WindDB().getWind(idPark, idPark1);
            windDirection = d.getCrosswind();
            windSpeed = calculateWindDirectionRelatedToTheRoute(windDirection, d.getWindspeed(), p1.getLatitude(), p1.getLongitude(), p2.getLatitude(), p2.getLongitude());
        }
        double speedAvg = user.getAvgSpeed();
        double angulo = Math.toDegrees(Math.asin(altitude / distance));
        double anguloOp = 0;
        double finalSpeed;
        
        if (angulo == 0) {
            if (windDirection < 90) {
                anguloOp = windDirection;
            } else if (windDirection > 90 && windDirection < 180) {
                anguloOp = 180 - windDirection;
            } else if (windDirection > 180 && windDirection < 270) {
                anguloOp = windDirection - 180;
            } else if (windDirection > 270 && windDirection < 360) {
                anguloOp = 270 - windDirection;
            }
            finalSpeed = Math.cos(Math.toRadians(anguloOp)) * windSpeed * speedAvg;
            if (windDirection == 90 || windDirection == 270) {
                finalSpeed = speedAvg;
            } else if (windDirection == 180 || windDirection == 0 || windDirection == 360) {
                finalSpeed = speedAvg * windSpeed;
            }
        } else {
            double ang = angulo + windDirection;

            if (ang < 90) {
                anguloOp = 180 - windDirection - angulo;
            } else if ((ang > 90 && ang < 180) || (ang > 180 && ang < 270)) {
                anguloOp = 180 - windDirection - angulo;
            } else if (ang > 270 && ang < 360) {
                anguloOp = 360 - windDirection - angulo;
            }
            finalSpeed = Math.cos(Math.toRadians(anguloOp)) * windSpeed * speedAvg * Math.cos(Math.toRadians(angulo)) + Math.sin(Math.toRadians(anguloOp)) * windSpeed * speedAvg * Math.sin(Math.toRadians(angulo));
            if (finalSpeed < 0) {
                finalSpeed = finalSpeed * -1;
            }
            if (ang == 90 || ang == 270) {
                finalSpeed = windSpeed * Math.sin(Math.toRadians(angulo)) * speedAvg;
            } else if (ang == 180 || ang == 270) {
                finalSpeed = windSpeed * Math.cos(Math.toRadians(angulo)) * speedAvg;
            }
        }

        double forcaArrasto = DENSITY * finalSpeed * bike.getAerodynamicCoefficient() * bike.getArea() / 2;
        double forcaAtrito = bike.getMechanicalCoefficient() +d.getCineticFriction() * (bike.getWeight() * 10 );
        return Math.abs(forcaArrasto - forcaAtrito) * distance;
    }

    public static double timeToCharge(Park a, Bike bk) {
        double maxCap = Double.parseDouble(bk.getMaxCapacity());
        double battery = Double.parseDouble(bk.getBattery());
        double capAtm = Double.parseDouble(bk.getMaxCapacity()) * (battery / 100);
        return capAtm / a.getChargingSpeed();
    }

    public static double calculateBearing(float latOrigin, float longOrigin, float latDestiny, float longDestiny) {
        double longitude1 = longOrigin;
        double longitude2 = longDestiny;
        double latitude1 = Math.toRadians(latOrigin);
        double latitude2 = Math.toRadians(latDestiny);
        double longDiff = Math.toRadians(longitude2 - longitude1);
        double y = Math.sin(longDiff) * Math.cos(latitude2);
        double x = Math.cos(latitude1) * Math.sin(latitude2) - Math.sin(latitude1) * Math.cos(latitude2) * Math.cos(longDiff);

        return (Math.toDegrees(Math.atan2(y, x)) + 360) % 360;
    }

    public static double calculateWindDirectionRelatedToTheRoute(float crosswind, double windspeed, float latOrigin, float longOrigin, float latDestiny, float longDestiny) {

        double bearing = calculateBearing(latOrigin, longOrigin, latDestiny, longDestiny);

        double alpha = crosswind - bearing;

        double x = 0;

        if (alpha != 90 && alpha != 270) {
            x = Math.cos(alpha) * windspeed;
            if (alpha > 90 && alpha < 270) {
                x = -x;
            }
        } else {
            x = 0;
        }

        return x;
    }

}
