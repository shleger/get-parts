package ru.saa.part.springrf.server.locator.spring;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.web.bindery.requestfactory.shared.Locator;

public class GWTSpringEntityLocator<T extends HasVersionAndId> extends
        Locator<T, Long> {


    @PersistenceContext
    EntityManager entityManager;


    @Override
    public T create(Class<? extends T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T find(Class<? extends T> clazz, Long id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public Class<T> getDomainType() {
        // Unused, and if it becomes used, we're in trouble
        throw new UnsupportedOperationException();
    }

    @Override
    public Long getId(T domainObject) {
        return domainObject.getId();
    }

    @Override
    public Class<Long> getIdType() {
        return Long.class;
    }

    @Override
    public Object getVersion(T domainObject) {
        return domainObject.getVersion();
    }
}