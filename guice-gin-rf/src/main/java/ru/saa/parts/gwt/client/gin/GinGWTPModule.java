package ru.saa.parts.gwt.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import ru.saa.parts.gwt.client.presenters.home.HomePageView;
import ru.saa.parts.gwt.client.presenters.home.HomePresenter;
import ru.saa.parts.gwt.client.presenters.home.MyPlaceManager;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 26.12.12
 * Time: 12:31
 * To change this template use File | Settings | File Templates.
 */
public class GinGWTPModule extends AbstractPresenterModule {
    @Override
    protected void configure() {

        install(new DefaultModule(MyPlaceManager.class));


        bindPresenter(HomePresenter.class, HomePresenter.HomeView.class, HomePageView.class, HomePresenter.HomeProxy.class);
    }
}
