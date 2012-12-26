package ru.saa.parts.gwt.client.presenters.about;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;
import ru.saa.parts.gwt.client.presenters.StringTokens;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 26.12.12
 * Time: 10:50
 * To change this template use File | Settings | File Templates.
 */
public class AboutPresenter extends Presenter<AboutPresenter.AboutView, AboutPresenter.AboutProxy> {


    private final PlaceManager placeManager;

    @Inject
    public AboutPresenter(EventBus eventBus, AboutView view, AboutProxy proxy, PlaceManager placeManager) {
        super(eventBus, view, proxy);
        this.placeManager = placeManager;
    }


    public interface AboutView extends View {

    }



    @ProxyCodeSplit
    @NameToken(StringTokens.ABOUT)
    public interface AboutProxy extends ProxyPlace<AboutPresenter> {
    }

    @Override
    protected void revealInParent() {
        RevealRootContentEvent.fire(this, this);
    }
}
