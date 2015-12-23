package de.cinex.rest;

import de.cinex.database.Transaction;
import de.cinex.domain.GeoData;
import de.cinex.logic.GeoLogic;
import groovy.lang.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.Collection;

@Path("/api/geo")
@Produces({"application/json"}) // mime type
@Singleton
public class GeoService {

    @Inject
    Transaction transaction;
    @Inject
    GeoLogic geoLogic;

    private static final Logger log = LoggerFactory.getLogger(GeoService.class);


    @Path("/get/distance/{lat1}/{long1}/{lat2}/{long2}")
    @GET
    public double getDistance(@PathParam("lat1") double lat1, @PathParam("long1") double long1, @PathParam("lat2") double lat2, @PathParam("long2") double long2) {
        double distance = 0;
        try {
            transaction.begin();
            log.debug("GET Distance between " + lat1 + " " + long1 + " and " + lat2 + " " + long2);
            distance = geoLogic.getDistance(lat1, long1, lat2, long2);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getLocalizedMessage());
        }
        return distance;
    }

    @Path("/get/geodata/list")
    @GET
    public Collection<GeoData> getGeoDataList() {
        Collection<GeoData> geoDatas;
        transaction.begin();
        log.debug("GET GeoData List");
        geoDatas = geoLogic.getGeoDataList();
        transaction.commit();
        return geoDatas;
    }



    @Path("/post/geodata/{username}/{password}/{longitude}/{latitude}")
    @POST
    public String postGeoData(@PathParam("username") String username, @PathParam("password") String password, @PathParam("longitude") double longitude, @PathParam("latitude") double latitude) {
        String check = "true";
        try {
            transaction.begin();
            log.debug("Update GeoData for User " + username);
            geoLogic.postGeoData(username, password, longitude, latitude);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getLocalizedMessage());
            check = "false";
        }
        return check;
    }
}
