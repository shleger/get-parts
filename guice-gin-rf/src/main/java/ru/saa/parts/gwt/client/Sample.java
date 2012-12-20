package ru.saa.parts.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
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

       final MainRequestFactory rf = injector.getMainRequestFactory();

//        MainRequestFactory  rf = GWT.create(MainRequestFactory.class);
//        rf.initialize(new SimpleEventBus());

       final  FieldLabel label = new FieldLabel();
       final  FieldLabel label2 = new FieldLabel();
        label2.setWidth("400px");

        label.setText("ReqFact: " + rf);

        rf.dataRequestContext().getData().fire(new Receiver<DataProxy>() {
            @Override
            public void onSuccess(DataProxy dataProxy) {
                label2.setText("fetch" + dataProxy.getName() + "  ver: " + dataProxy.getVersion());
            }
        });


        TextButton textButton = new TextButton();

        textButton.setText("gxtTextButton");

        textButton.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {

                rf.dataRequestContext().getData().fire(new Receiver<DataProxy>() {
                    @Override
                    public void onSuccess(DataProxy dataProxy) {
                        Window.alert("textButton.addSelectHandler" + "fetch: " + dataProxy.getName() + "  ver: " + dataProxy.getVersion());
                    }
                });
            }
        })   ;

        Button simpleButton = new Button();
        simpleButton.setText("simpleButton");

        simpleButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                rf.dataRequestContext().getData().fire(new Receiver<DataProxy>() {
                    @Override
                    public void onSuccess(DataProxy dataProxy) {
                        Window.alert("fetch: " + dataProxy.getName() + "  ver: " + dataProxy.getVersion());
                    }
                });

            }
        });

        VerticalPanel panel = new VerticalPanel();
        panel.setWidth("400px");
        panel.setBorderWidth(1);

        panel.add(label);
        panel.add(label2);
        panel.add(textButton);
        panel.add(simpleButton);

        RootPanel.get().add(panel);



    }
}
