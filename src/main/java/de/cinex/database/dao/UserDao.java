package de.cinex.database.dao;

import de.cinex.domain.UserData;
import de.cinex.domain.UuId;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import java.util.Collection;

@ApplicationScoped
public class UserDao extends JpaDao<UuId, UserData> {

    public UserDao() {
        super(UserData.class);
    }

    //@SuppressWarnings("unchecked")
    public Collection<UserData> findByName(String username) {
        Query query = entityManager.createQuery("SELECT u from User u where u.username = :username");
        query.setParameter("username", username);
        return (Collection<UserData>) query.getResultList();
    }

    public UserData findByUserName(String username) {
        Query query = entityManager.createQuery("SELECT u from User u where u.username = :username");
        query.setParameter("username", username);
        return (UserData) query.getResultList().get(0);
    }

    public UserData findByUuId(UuId uuId) {
        Query query = entityManager.createQuery("SELECT u from UserData u where u.uuid = :uuId");
        query.setParameter("uuId", uuId);
        return (UserData) query.getSingleResult();
    }


}
