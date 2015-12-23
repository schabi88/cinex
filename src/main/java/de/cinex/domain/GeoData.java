package de.cinex.domain;


import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@XmlRootElement
public class GeoData extends PersistentObject {


    /**
     * --------------------VARIABLES-----------------------------
     **/

    private String username;
    private double longitude;        // Längengrad
    private double latitude;         // Breitengrad
    private Date date;

    /**
     * --------------------Getter/Setter-----------------------------
     **/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Date getDate() {
        return date;
    }

    public void setDate() {
        this.date = new Date();
    }
}
