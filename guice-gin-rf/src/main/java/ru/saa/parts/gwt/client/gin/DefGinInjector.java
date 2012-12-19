package ru.saa.parts.gwt.client.gin;

import com.google.gwt.inject.client.Ginjector;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 19.12.12
 * Time: 16:42
 * To change this template use File | Settings | File Templates.
 */
public interface DefGinInjector extends Ginjector {
    EventBus getEventBus();
}
