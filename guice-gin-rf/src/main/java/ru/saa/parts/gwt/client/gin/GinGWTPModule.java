package ru.saa.parts.gwt.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import ru.saa.parts.gwt.client.presenters.about.AboutPageView;
import ru.saa.parts.gwt.client.presenters.about.AboutPresenter;
import ru.saa.parts.gwt.client.presenters.home.HomePageView;
import ru.saa.parts.gwt.client.presenters.home.HomePresenter;
import ru.saa.parts.gwt.client.presenters.MyPlaceManager;

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

//        Installing DefaultModule saves you from having to perform all the following bindings:
//
//        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
//        bind(TokenFormatter.class).to(ParameterTokenFormatter.class).in(Singleton.class);
//        bind(RootPresenter.class).asEagerSingleton();
//        bind(PlaceManager.class).to(MyPlaceManager.class).in(Singleton.class);
//        bind(GoogleAnalytics.class).to(GoogleAnalyticsImpl.class).in(Singleton.class);
        install(new DefaultModule(MyPlaceManager.class));


        //don't forget setup AsyncProvider<?Presenter> get?Presenter();
        bindPresenter(HomePresenter.class, HomePresenter.HomeView.class, HomePageView.class, HomePresenter.HomeProxy.class);
        bindPresenter(AboutPresenter.class, AboutPresenter.AboutView.class, AboutPageView.class, AboutPresenter.AboutProxy.class);

    }
}
