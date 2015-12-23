package de.cinex.rest;

import de.cinex.database.Transaction;
import de.cinex.database.dao.MovieDao;
import de.cinex.domain.MovieData;
import de.cinex.logic.MovieLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Rest Service to represent the MovieData object and enable access to the database
 * <p>
 * <p>
 * Methods:
 * - add: adds new movie to the database, consumes HTML form and uses POST
 * -
 */

@Path("/api/movie")
@Produces({"application/json"})
@Singleton
public class MovieService {

    private static final Logger log = LoggerFactory.getLogger(MovieService.class);

    @Inject
    Transaction transaction;
    @Inject
    MovieLogic movieLogic;


    @Path("/get/moviedata/list")
    @GET
    public Collection<MovieData> getGeoDataList() {
        Collection<MovieData> movieDatas;
        transaction.begin();
        log.debug("GET GeoData List");
        movieDatas = movieLogic.getMovieDataList();
        transaction.commit();
        return movieDatas;
    }

    @Path("/post/moviedata")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String postMovieData(@FormParam("name") String name, @FormParam("age") int age, @FormParam("genre") String genre, @FormParam("duration") double duration, @FormParam("description") String description, @FormParam("cinename") String cinename, @FormParam("price") double price) {
        String check = "true";
        log.debug("Adding MovieData: " + name);
        try {
            transaction.begin();
            movieLogic.postMovieData(name, age, genre, duration, description, cinename, price);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getLocalizedMessage());
            check = "false";
        }
        return check;
    }


}
