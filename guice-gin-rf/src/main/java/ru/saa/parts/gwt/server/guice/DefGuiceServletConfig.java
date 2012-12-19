package ru.saa.parts.gwt.server.guice;

import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 19.12.12
 * Time: 15:59
 * To change this template use File | Settings | File Templates.
 */


public class DefGuiceServletConfig extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
