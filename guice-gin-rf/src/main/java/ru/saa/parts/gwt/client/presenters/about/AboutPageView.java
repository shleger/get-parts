package ru.saa.parts.gwt.client.presenters.about;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 26.12.12
 * Time: 13:43
 * To change this template use File | Settings | File Templates.
 */
public class AboutPageView extends ViewImpl implements AboutPresenter.AboutView {

    private Label label = new Label();

    @Override
    public Widget asWidget() {
        label.setText("AboutPageView");
        return label;
    }
}
