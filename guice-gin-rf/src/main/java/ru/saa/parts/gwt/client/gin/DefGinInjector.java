package ru.saa.parts.gwt.client.gin;

import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.client.gin.DispatchAsyncModule;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import ru.saa.parts.gwt.client.Messages;
import ru.saa.parts.gwt.client.presenters.about.AboutPresenter;
import ru.saa.parts.gwt.client.presenters.home.HomePresenter;
import ru.saa.parts.gwt.shared.service.MainRequestFactory;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 19.12.12
 * Time: 16:42
 * To change this template use File | Settings | File Templates.
 */
@GinModules({FirstGinModule.class, GinGWTPModule.class, DispatchAsyncModule.class})
public interface DefGinInjector extends Ginjector {


    EventBus getEventBus();
    MainRequestFactory getMainRequestFactory();

    //GWT Platform
    PlaceManager getPlaceManager();
    Messages getMessages();
    AsyncProvider<HomePresenter> getHomePresenter();
    AsyncProvider<AboutPresenter> getAboutPresenter();
}
