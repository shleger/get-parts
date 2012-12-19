package ru.saa.parts.gwt.server.guice;

import com.google.gwt.logging.server.RemoteLoggingServiceImpl;
import com.google.inject.servlet.ServletModule;
import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;

import javax.inject.Singleton;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 19.12.12
 * Time: 16:32
 * To change this template use File | Settings | File Templates.
 */
public class MainServletModule extends ServletModule {
    @Override
    protected void configureServlets() {
        // RequestFactory servlet
        bind(RequestFactoryServlet.class).in(Singleton.class);
        serve("/gwtRequest").with(RequestFactoryServlet.class);

        //Enable remote log
        install(new RemoteLoggingModule());
        serve("/sample/remoteLog").with(RemoteLoggingServiceImpl.class);
    }
}
