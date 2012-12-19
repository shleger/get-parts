package ru.saa.parts.gwt.shared.service;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.web.bindery.requestfactory.shared.Locator;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;
import ru.saa.parts.gwt.server.dao.DataDao;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 19.12.12
 * Time: 17:56
 * To change this template use File | Settings | File Templates.
 */
public class EntityServiceLocator implements ServiceLocator {


    @Override
    public Object getInstance(Class<?> clazz) {
        return new DataDao();
    }




    //todo fix err for this
//    private final Injector injector;
//
//    @Inject
//    public EntityServiceLocator(Injector injector) {
//        this.injector = injector;
//    }
//
//    @Override
//    public Object getInstance(Class<?> aClass) {
//        return injector.getInstance(aClass);
//    }
}
