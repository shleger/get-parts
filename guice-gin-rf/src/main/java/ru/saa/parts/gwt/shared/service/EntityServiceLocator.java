package ru.saa.parts.gwt.shared.service;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.web.bindery.requestfactory.shared.Locator;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 19.12.12
 * Time: 17:56
 * To change this template use File | Settings | File Templates.
 */
public class EntityServiceLocator implements ServiceLocator {

    private final Injector injector;

    @Inject
    public EntityServiceLocator(Injector injector) {
        this.injector = injector;
    }

    @Override
    public Object getInstance(Class<?> aClass) {
        return injector.getInstance(aClass);
    }
}
