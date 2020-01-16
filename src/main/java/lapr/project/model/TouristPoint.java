/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.Objects;
import lapr.project.data.TouristPointDB;

/**
 *
 * @author Daniela Vinagreiro
 */
public class TouristPoint {

    private int idTouristPoint;
    private String description;
    private float longitude;
    private float latitude;
    private float altitude;

    public TouristPoint(int idTouristPoint, String name, float latitude, float longitude, float altitude) {
        setIdTouristPoint(idTouristPoint);
        setDescription(name);
        setLatitude(latitude);
        setLongitude(longitude);
        setAltitude(altitude);
    }

    public TouristPoint() {

    }

    public static TouristPoint getTouristPoint(int idTouristPoint) {
        return new TouristPointDB().getTouristPoint(idTouristPoint);
    }

    public static double getDistanceBetweenTwoTouristPoints(TouristPoint toCheck, TouristPoint touristPoint) {
        float longitude = touristPoint.getLongitude();
        float latitude = touristPoint.getLatitude();
        float altitude = touristPoint.getAltitude();
        float toCheckLongitude = toCheck.getLongitude();
        float toCheckLatitude = toCheck.getLatitude();
        float toCheckALtitude = toCheck.getAltitude();
        return Operations.distanceCalculator(toCheckLongitude, toCheckLatitude, toCheckALtitude, longitude, latitude, altitude);
    }

    public int getIdTouristPoint() {
        return idTouristPoint;
    }

    public String getDescription() {
        return description;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setIdTouristPoint(int idTouristPoint) {
        this.idTouristPoint = idTouristPoint;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.idTouristPoint;
        hash = 83 * hash + Objects.hashCode(this.description);
        hash = 83 * hash + Float.floatToIntBits(this.latitude);
        hash = 83 * hash + Float.floatToIntBits(this.longitude);
        hash = 83 * hash + Float.floatToIntBits(this.altitude);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TouristPoint other = (TouristPoint) obj;
        if (this.idTouristPoint != other.idTouristPoint) {
            return false;
        }
        if (Float.floatToIntBits(this.latitude) != Float.floatToIntBits(other.latitude)) {
            return false;
        }
        if (Float.floatToIntBits(this.longitude) != Float.floatToIntBits(other.longitude)) {
            return false;
        }
        if (Float.floatToIntBits(this.altitude) != Float.floatToIntBits(other.altitude)) {
            return false;
        }
        return Objects.equals(this.description, other.description);
    }

    @Override
    public String toString() {
        return "TouristPoints" + "idTouristPoint=" + idTouristPoint + ", name=" + description + ", latitude=" + latitude + ", longitude=" + longitude + ", altitude=" + altitude;
    }

}
