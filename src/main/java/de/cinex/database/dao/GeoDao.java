package de.cinex.database.dao;

import de.cinex.domain.GeoData;
import de.cinex.domain.UuId;
import de.cinex.logic.GeoLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Query;
import java.util.Collection;


@ApplicationScoped
public class GeoDao extends JpaDao<UuId, GeoData> {
    private static final Logger log = LoggerFactory.getLogger(GeoDao.class);

    @Inject
    GeoLogic geoLogic;

    public GeoDao() {
        super(GeoData.class);
    }

//not needed anymore
    /*public Collection<GeoData> listGeo() {
        Query q = entityManager.createQuery("SELECT g FROM " + entityClass.getName() + " g");
        return q.getResultList();
    }*/

    public GeoData findByUserName(String username) {
        Query query = entityManager.createQuery("SELECT g FROM GeoData g WHERE g.username = :username ORDER BY g.date DESC");
        query.setParameter("username", username);
        return (GeoData) query.getResultList().get(0);
    }

    public void logOut(String username){
        Query q = entityManager.createQuery("UPDATE GeoData g SET g.active = false WHERE g.username = :username");
        q.setParameter("username", username);
        q.executeUpdate();
    }
}