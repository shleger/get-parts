package ru.saa.part.onlyrf.server;

import com.google.web.bindery.requestfactory.server.ExceptionHandler;
import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import com.google.web.bindery.requestfactory.shared.ServerFailure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: saa
 * Date: 8/13/13
 * Time: 02:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class CustomRequestFactoryServlet extends RequestFactoryServlet {

    static class LoquaciousExceptionHandler implements ExceptionHandler {
        private static final Logger LOG = LoggerFactory.getLogger(LoquaciousExceptionHandler.class);

        @Override
        public ServerFailure createServerFailure( Throwable throwable ) {
            LOG.error( "Server error", throwable );
            return new ServerFailure( throwable.getMessage(), throwable.getClass().getName(), null, true );
        }
    }

    public CustomRequestFactoryServlet() {
        super( new LoquaciousExceptionHandler() );
    }
}