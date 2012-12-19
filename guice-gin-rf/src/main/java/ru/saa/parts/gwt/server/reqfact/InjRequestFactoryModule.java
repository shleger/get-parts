package ru.saa.parts.gwt.server.reqfact;

import com.google.inject.AbstractModule;
import org.hibernate.ejb.event.EJB3SaveEventListener;
import ru.saa.parts.gwt.shared.service.EntityServiceLocator;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 19.12.12
 * Time: 17:59
 * To change this template use File | Settings | File Templates.
 */
public class InjRequestFactoryModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(EntityServiceLocator.class);
    }
}
