package de.cinex.database.dao;

import de.cinex.domain.MovieData;
import de.cinex.domain.UuId;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MovieDao extends JpaDao<UuId, MovieData> {

    public MovieDao() {
        super(MovieData.class);
    }

}
