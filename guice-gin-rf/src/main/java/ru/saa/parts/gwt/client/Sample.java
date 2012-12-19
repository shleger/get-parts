package ru.saa.parts.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import ru.saa.parts.gwt.client.gin.DefGinInjector;
import ru.saa.parts.gwt.shared.proxy.DataProxy;
import ru.saa.parts.gwt.shared.service.MainRequestFactory;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 19.12.12
 * Time: 16:39
 * To change this template use File | Settings | File Templates.
 */
public class Sample implements EntryPoint {
    public final  DefGinInjector injector = GWT.create(DefGinInjector.class);

    @Override
    public void onModuleLoad() {

        MainRequestFactory rf = injector.getMainRequestFactory();

//        MainRequestFactory  rf = GWT.create(MainRequestFactory.class);
//        rf.initialize(new SimpleEventBus());

       final  FieldLabel label = new FieldLabel();
       final  FieldLabel label2 = new FieldLabel();

        label.setText("ReqFact: " + rf);

        rf.dataRequestContext().getData().fire(new Receiver<DataProxy>() {
            @Override
            public void onSuccess(DataProxy dataProxy) {
                label2.setText("fetch" + dataProxy.getName() + "  ver: " + dataProxy.getVersion());
            }
        });




        RootPanel.get().add(label);
        RootPanel.get().add(label2);

    }
}
