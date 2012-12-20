package ru.saa.part.onlyrf.server.locator;

import com.google.web.bindery.requestfactory.shared.ServiceLocator;

public class MyServiceLocator implements ServiceLocator {
    @Override
    public Object getInstance(Class<?> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}