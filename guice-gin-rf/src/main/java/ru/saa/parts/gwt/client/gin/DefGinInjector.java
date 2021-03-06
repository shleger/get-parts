package ru.saa.parts.gwt.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.web.bindery.event.shared.EventBus;
import ru.saa.parts.gwt.shared.service.MainRequestFactory;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 19.12.12
 * Time: 16:42
 * To change this template use File | Settings | File Templates.
 */
@GinModules(FirstGinModule.class)
public interface DefGinInjector extends Ginjector {


    EventBus getEventBus();
    MainRequestFactory getMainRequestFactory();
}
