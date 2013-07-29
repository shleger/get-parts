package ru.saa.part.springrf.client;

import com.google.gwt.user.client.Window;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.layout.VLayout;
import ru.saa.part.springrf.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import ru.saa.part.springrf.shared.proxy.EmployeeProxy;
import ru.saa.part.springrf.shared.services.ExpensesRequestFactory;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SampleRf implements EntryPoint {
    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";

    /**
     * Create a remote service proxy to talk to the server-side Greeting service.
     */
    private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

    private final Messages messages = GWT.create(Messages.class);

    private final ExpensesRequestFactory requestFactory = GWT.create(ExpensesRequestFactory.class);

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {



        final EventBus eventBus = new SimpleEventBus();
        requestFactory.initialize(eventBus);

        System.out.println("SampleRf.onModuleLoad: " + requestFactory );

        DataSource ds = new DataSource();
        ds.setID("employee");

        DataSourceTextField dsName = new DataSourceTextField("userName");
        DataSourceTextField dsDepartment = new DataSourceTextField("department");
        DataSourceTextField dsDisplayName = new DataSourceTextField("displayName");
        DataSourceTextField dsPassword = new DataSourceTextField("password");

        ds.setFields(dsName,dsDepartment,dsDisplayName,dsName,dsPassword);

        final IButton reqFacButton = new IButton("getEmployee");

        reqFacButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                requestFactory.employeeRequest().findEmployee(1L).fire(new Receiver<EmployeeProxy>() {
                    @Override
                    public void onSuccess(EmployeeProxy employeeProxy) {
                        Window.alert("Empl:" + employeeProxy.getUserName() + ", id=" + employeeProxy.getId());
                    }
                });
            }
        });


        final DynamicForm form = new DynamicForm();
        form.setWidth(300);
        form.setDataSource(ds);

        VLayout vLayout = new VLayout();
        vLayout.setMembersMargin(10);
        vLayout.addMember(form);
        vLayout.addMember(reqFacButton);

        RootPanel.get().add(vLayout);



    }
}
