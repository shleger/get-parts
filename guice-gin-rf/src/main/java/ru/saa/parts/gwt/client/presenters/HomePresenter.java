package ru.saa.parts.gwt.client.presenters;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 26.12.12
 * Time: 10:50
 * To change this template use File | Settings | File Templates.
 */
public class HomePresenter extends Presenter<HomePresenter.HomeView, HomePresenter.HomeProxy> {


    private final PlaceManager placeManager;

    @Inject
    public HomePresenter(EventBus eventBus, HomeView view, HomeProxy proxy, PlaceManager placeManager) {
        super(eventBus, view, proxy);
        this.placeManager = placeManager;
    }


    interface HomeView extends View {

    }

    interface HomeProxy extends Proxy<HomePresenter>, Place {

    }

    @Override
    protected void revealInParent() {
        RevealRootContentEvent.fire(this, this);
    }
}
