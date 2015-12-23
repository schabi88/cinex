package de.cinex.logic;

import de.cinex.database.dao.MovieDao;
import de.cinex.domain.MovieData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Collection;
/**
 * This class contains the Logic for the Entity MovieData
 *
 * STRUCTURE:
 *            - GET:
 *                    x getMovieDataList()
 *                    x
 *                    x
 *
 *            - POST:
 *                    x postMovieData()
 *                    x
 *                    x
 *
 *            - DELETE:
 *
 *                    x
 *                    x
 *
 */
public class MovieLogic {

    @Inject
    MovieDao movieDao;

    private static final Logger log = LoggerFactory.getLogger(MovieLogic.class);


    /**
     * -------------------GET------------------------
     */

    public Collection<MovieData> getMovieDataList() {
        return movieDao.list();
    }


    /**
     * -------------------POST------------------------
     */

    public void postMovieData(String name, int age, String genre, double duration, String description, String cinename, double price) {

        MovieData newMovieData = new MovieData();
        try {
            newMovieData.setName(name);
            newMovieData.setAge(age);
            newMovieData.setGenre(genre);
            newMovieData.setDuration(duration);
            newMovieData.setDescription(description);
            newMovieData.setCinemaname(cinename);
            newMovieData.setPrice(price);
        } catch (Exception e) {
            log.debug(e.getLocalizedMessage());
            e.printStackTrace();
        }

        try {
            movieDao.persist(newMovieData);
        } catch (Exception e) {
            log.debug(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

}
