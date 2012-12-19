package ru.saa.parts.gwt.server.guice;

import com.google.gwt.logging.server.RemoteLoggingServiceImpl;
import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 19.12.12
 * Time: 16:34
 * To change this template use File | Settings | File Templates.
 */
public class RemoteLoggingModule extends ServletModule {
    @Override
    protected void configureServlets() {
        bind(RemoteLoggingServiceImpl.class).in(Singleton.class);
    }
}
