package ru.saa.parts.gwt.server.dao;

import com.google.inject.Inject;
import ru.saa.parts.gwt.server.domain.ExamplePersistedClass;

import javax.persistence.EntityManager;

/**
 * $Revision:  $
 * $Author: shleger $
 * $Date: 25.07.13 14:20  $
 *
 * from http://www.benmccann.com/blog/hibernate-with-jpa-annotations-and-guice/
 */
public class ExamplePersistedClassDao {

    protected EntityManager entityManager;

    @Inject
    public ExamplePersistedClassDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveInNewTransaction(ExamplePersistedClass object) {
        entityManager.getTransaction().begin();
        save(object);
        entityManager.getTransaction().commit();
    }

    public void save(ExamplePersistedClass object) {
        entityManager.persist(object);
    }

    public ExamplePersistedClass getByOtherField(String otherField) {
        return (ExamplePersistedClass) entityManager
                .createQuery("select e from ru.saa.parts.gwt.server.domain.ExamplePersistedClass e where e.otherField=:otherField")
                .setParameter("otherField", otherField)
                .getSingleResult();
    }

}