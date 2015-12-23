package de.cinex.logic;

import de.cinex.database.dao.GeoDao;
import de.cinex.database.dao.UserDao;
import de.cinex.domain.GeoData;
import de.cinex.domain.UserData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * This class contains the Logic for the Entity GeoData
 * <p>
 * STRUCTURE:
 * - GET:
 * x getDistance()
 * x getGeoDataList()
 * x
 * x
 * <p>
 * - POST:
 * x postGeoData()
 * x
 * x
 * x
 * <p>
 * - DELETE:
 * <p>
 * x
 * x
 */
public class GeoLogic {

    private static final Logger log = LoggerFactory.getLogger(GeoLogic.class);

    @Inject
    UserDao userDao;
    @Inject
    GeoDao geoDao;

    /**
     * -------------------GET------------------------
     */

    public double getDistance(double lat1, double long1, double lat2, double long2) {
        double earthRadius = 6371.0; // km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLong = Math.toRadians(long2 - long1);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLong / 2);
        double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return earthRadius * c;
    }

    public Collection<GeoData> getGeoDataList() {
        return geoDao.list();
    }

    /**
     * -------------------POST------------------------
     */

    public String postGeoData(String username, String password, double longitude, double latitude) {
        String check = "true";
        try {
            GeoData thisgeoData = new GeoData();
            UserData thisuserData = userDao.findByUserName(username);
            thisgeoData.setLatitude(latitude);
            thisgeoData.setLongitude(longitude);
            thisgeoData.setUsername(thisuserData.getUsername());
            thisgeoData.setDate();
            geoDao.persist(thisgeoData);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getLocalizedMessage());
            check = "false";
        }
        return check;
    }
}

