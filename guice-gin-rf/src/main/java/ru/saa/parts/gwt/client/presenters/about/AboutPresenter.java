package ru.saa.parts.gwt.client.presenters.about;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;
import ru.saa.parts.gwt.client.presenters.StringTokens;
import ru.saa.parts.gwt.shared.command.SendTextRequest;
import ru.saa.parts.gwt.shared.command.SendTextResponse;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 26.12.12
 * Time: 10:50
 * To change this template use File | Settings | File Templates.
 */
public class AboutPresenter extends Presenter<AboutPresenter.AboutView, AboutPresenter.AboutProxy> {


    private final PlaceManager placeManager;
    private final DispatchAsync dispatcher;
    private String sendText;



    @Inject
    public AboutPresenter(EventBus eventBus, AboutView view, AboutProxy proxy, PlaceManager placeManager, DispatchAsync dispatcher) {
        super(eventBus, view, proxy);
        this.placeManager = placeManager;
        this.dispatcher = dispatcher;
    }


    public interface AboutView extends View {

        void setRequest(String req);
        void setResponse(String resp);


    }



    @ProxyCodeSplit
    @NameToken(StringTokens.ABOUT)
    public interface AboutProxy extends ProxyPlace<AboutPresenter> {
    }

    @Override
    protected void revealInParent() {
        RevealRootContentEvent.fire(this, this);
    }

    @Override
    protected void onReset() {
        super.onReset();
        getView().setRequest("setReqFromAbout");
        getView().setResponse("Waiting for any response....");

        AsyncCallback<SendTextResponse> asyncResp = new AsyncCallback<SendTextResponse>() {
            @Override
            public void onFailure(Throwable throwable) {

                getView().setResponse("Error: " +throwable.getMessage());

            }

            @Override
            public void onSuccess(SendTextResponse sendTextResponse) {

                getView().setResponse(sendTextResponse.getRes());

            }
        };

        SendTextRequest req = new SendTextRequest();
        req.setReq("setReqInHandler");

        dispatcher.execute(req,asyncResp);
    }

    public String getSendText() {
        return sendText;
    }

    public void setSendText(String sendText) {
        this.sendText = sendText;
    }
}
