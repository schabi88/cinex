package de.cinex.database.dao;


import de.cinex.domain.PersistentObject;
import de.cinex.domain.UuId;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

public abstract class JpaDao<ID extends UuId, TYPE extends PersistentObject> implements Dao<ID, TYPE> {

    protected Class<TYPE> entityClass; //entityClass is the main class for operations, it can only be of the Type "TYPE"

    @PersistenceContext
    protected EntityManager entityManager;

    public JpaDao(Class<TYPE> entityClass) {
        this.entityClass = entityClass;
    } //entityClass equals the "TYPE" class

    public void persist(TYPE entity) {
        entityManager.persist(entity);
    }

    public void delete(ID id) {
        try {
            TYPE entity = get(id);            //declaration of the a new instance of TYPE bzw. PersistentObject(User) which is the entitty that should be deleted
            entityManager.remove(entity);     //delete user with  from the database
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public TYPE get(ID id) {
        return entityManager.find(entityClass, id);
    }  //finds user by primary key "id" and returns the entity object "TYPE"


    @SuppressWarnings("unchecked")
    public Collection<TYPE> list() {
        Query q = entityManager.createQuery("select e from " + entityClass.getName() + " e");
        return (Collection<TYPE>) q.getResultList();
    }

}