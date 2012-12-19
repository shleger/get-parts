package ru.saa.parts.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import ru.saa.parts.gwt.client.gin.DefGinInjector;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 19.12.12
 * Time: 16:39
 * To change this template use File | Settings | File Templates.
 */
public class Sample implements EntryPoint {
    private DefGinInjector injector = GWT.create(DefGinInjector.class);

    @Override
    public void onModuleLoad() {



        FieldLabel label = new FieldLabel();

        label.setText("jjjjjj");

        RootPanel.get().add(label);

    }
}
