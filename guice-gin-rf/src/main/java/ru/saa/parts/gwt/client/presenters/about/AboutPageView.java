package ru.saa.parts.gwt.client.presenters.about;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 26.12.12
 * Time: 13:43
 * To change this template use File | Settings | File Templates.
 */
public class AboutPageView extends ViewImpl implements AboutPresenter.AboutView {

    private static String html =
            "<h1>ABOUT PRESENTER FOR  GWTP Web Application</h1>\n" +
                    "<a href=# >homePresenter</a>  \n"+
                    "<table align=\"center\">\n" +
                    "  <tr>\n" +
                    "    <td colspan=\"2\" style=\"font-weight:bold;\">Please enter your name:</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td id=\"nameFieldContainer\"></td>\n" +
                    "    <td id=\"sendButtonContainer\"></td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td colspan=\"2\" style=\"color:red;\" id=\"errorLabelContainer\"></td>\n" +
                    "  </tr>\n" +
                    "</table>\n";

    HTMLPanel panel = new HTMLPanel(html);

    @Inject
    public AboutPageView() {
        final Button sendButton = new Button("Send");
        final TextBox nameField = new TextBox();
        nameField.setText("GWT User");

        sendButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                Window.alert("About.User: " + nameField.getValue());
            }
        }) ;

        final Label errorLabel = new Label();

        // We can add style names to widgets
//        sendButton.addStyleName("sendButton");

        // Add the nameField and sendButton to the RootPanel
        // Use RootPanel.get() to get the entire body element
        panel.add(nameField, "nameFieldContainer");
        panel.add(sendButton, "sendButtonContainer");
        panel.add(errorLabel, "errorLabelContainer");
    }

    @Override
    public Widget asWidget() {
        return panel;
    }

}