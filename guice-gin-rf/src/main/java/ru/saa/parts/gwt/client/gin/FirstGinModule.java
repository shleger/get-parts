package ru.saa.parts.gwt.client.gin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provides;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import ru.saa.parts.gwt.shared.service.MainRequestFactory;

import javax.inject.Singleton;

/**
 * Created with IntelliJ IDEA.
 * User: saa
 * Date: 12/20/12
 * Time: 24:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class FirstGinModule extends AbstractGinModule {
    @Override
    protected void configure() {
//        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
        bind(MainRequestFactory.class).in(Singleton.class);
    }


    @Provides
    @Singleton
    MainRequestFactory createMainRequestFactory(EventBus bus) {
        MainRequestFactory mainRequestFactory = GWT.create(MainRequestFactory.class);
        mainRequestFactory.initialize(bus);
        return mainRequestFactory;
    }

}
