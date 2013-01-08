package ru.saa.parts.gwt.server.guice;

import com.google.inject.servlet.ServletModule;
import com.gwtplatform.dispatch.server.guice.DispatchServiceImpl;
import com.gwtplatform.dispatch.shared.ActionImpl;

/**
 * Created with IntelliJ IDEA.
 * User: saa
 * Date: 1/8/13
 * Time: 04:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class DispatchServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
        serve("/" + ActionImpl.DEFAULT_SERVICE_NAME + "*").with(
                DispatchServiceImpl.class);
    }
}
