package ru.saa.part.springrf.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.data.shared.SortInfo;
import com.sencha.gxt.data.shared.loader.*;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.filters.GridFilters;
import com.sencha.gxt.widget.core.client.grid.filters.StringFilter;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar;
import ru.saa.part.springrf.shared.proxy.EmployeeProxy;
import ru.saa.part.springrf.shared.services.EmployeeRequest;
import ru.saa.part.springrf.shared.services.ExpensesRequestFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SampleRf implements EntryPoint, IsWidget {

    interface EmployeeProxyProperties extends PropertyAccess<EmployeeProxy> {
        ModelKeyProvider<EmployeeProxy> id();

        ValueProvider<EmployeeProxy, String> department();

        ValueProvider<EmployeeProxy, String> displayName();

        ValueProvider<EmployeeProxy, String> password();

        ValueProvider<EmployeeProxy, String> userName();

        ValueProvider<EmployeeProxy, EmployeeProxy> supervisor();
    }

//    private TextButton saveButton = new TextButton("saveButton1");
//    private HorizontalPanel hp;

    /**
     * Create a remote service proxy to talk to the server-side Greeting service.
     */

    private final Messages messages = GWT.create(Messages.class);

    private final ExpensesRequestFactory requestFactory = GWT.create(ExpensesRequestFactory.class);

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {


        System.out.println("SampleRf.onModuleLoad: " + requestFactory);


        RootPanel.get().add(this);


        //--fetch

//        requestFactory.employeeRequest().findEmployee(1L).fire(new Receiver<EmployeeProxy>() {
//            @Override
//            public void onSuccess(EmployeeProxy employeeProxy) {
//                Window.alert("Empl:" + employeeProxy.getUserName() + ", id=" + employeeProxy.getId());
//            }
//        });

//
//                requestFactory.employeeRequest().getEmployees(0,10, new ArrayList(),new ArrayList()).fire(new Receiver<EmployeeRequest.EmployeePagingProxy>() {
//
//                    @Override
//                    public void onSuccess(EmployeeRequest.EmployeePagingProxy postPagingLoadResultProxy) {
//                        Window.alert("Empl:" + postPagingLoadResultProxy);
//
//                    }
//                });


    }

    @Override
    public Widget asWidget() {

        TextButton textButton = new TextButton("addRow");

        textButton.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {

                //--saveButton

                EmployeeRequest request = requestFactory.employeeRequest();
                EmployeeProxy newEmployee = request.create(EmployeeProxy.class);

                Random random = new Random();
                final int RND_MAX = 99;


                newEmployee.setDisplayName("display name" + random.nextInt(RND_MAX));
                newEmployee.setDepartment("depart" + +random.nextInt(RND_MAX));
                newEmployee.setUserName("usr name" + random.nextInt(RND_MAX));
                newEmployee.setPassword("usr pass" + random.nextInt(RND_MAX));


                Request<Void> createReq = request.persist(newEmployee);

                createReq.fire(new Receiver<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Window.alert("Employee:" + "saved");

                    }
                });

            }
        });


        final EventBus eventBus = new SimpleEventBus();
        requestFactory.initialize(eventBus);

        RequestFactoryProxy<FilterPagingLoadConfig, PagingLoadResult<EmployeeProxy>> proxy = new RequestFactoryProxy<FilterPagingLoadConfig, PagingLoadResult<EmployeeProxy>>() {
            @Override
            public void load(FilterPagingLoadConfig loadConfig, Receiver<? super PagingLoadResult<EmployeeProxy>> receiver) {


                EmployeeRequest req = requestFactory.employeeRequest();
                final List<SortInfo> sortInfo = createRequestSortInfo(req, loadConfig.getSortInfo());
                final List<FilterConfig> filterConfig = createRequestFilterConfig(req, loadConfig.getFilters());
                req.getEmployees(loadConfig.getOffset(), loadConfig.getLimit(), sortInfo, filterConfig).to(receiver);
                req.fire();


            }
        };


        final PagingLoader<FilterPagingLoadConfig, PagingLoadResult<EmployeeProxy>> loader = new PagingLoader<FilterPagingLoadConfig, PagingLoadResult<EmployeeProxy>>(
                proxy) {
            @Override
            protected FilterPagingLoadConfig newLoadConfig() {
                return new FilterPagingLoadConfigBean();
            }
        };

        loader.setRemoteSort(true);


        EmployeeProxyProperties props = GWT.create(EmployeeProxyProperties.class);


        ListStore<EmployeeProxy> store = new ListStore<EmployeeProxy>(props.id());
        loader.addLoadHandler(new LoadResultListStoreBinding<FilterPagingLoadConfig, EmployeeProxy, PagingLoadResult<EmployeeProxy>>(
                store));

        final PagingToolBar toolBar = new PagingToolBar(50);
        toolBar.getElement().getStyle().setProperty("borderBottom", "none");
        toolBar.bind(loader);


        ColumnConfig<EmployeeProxy, String> department = new ColumnConfig<EmployeeProxy, String>(props.department(), 150, "department");
        ColumnConfig<EmployeeProxy, String> userName = new ColumnConfig<EmployeeProxy, String>(props.userName(), 150, "user Name");
        ColumnConfig<EmployeeProxy, String> displayName = new ColumnConfig<EmployeeProxy, String>(props.displayName(), 150, "display Name");
        ColumnConfig<EmployeeProxy, String> password = new ColumnConfig<EmployeeProxy, String>(props.password(), 150, "password");


        List<ColumnConfig<EmployeeProxy, ?>> l = new ArrayList<ColumnConfig<EmployeeProxy, ?>>();
        l.add(department);
        l.add(userName);
        l.add(displayName);
        l.add(password);


        ColumnModel<EmployeeProxy> cm = new ColumnModel<EmployeeProxy>(l);


        Grid<EmployeeProxy> view = new Grid<EmployeeProxy>(store, cm) {
            @Override
            protected void onAfterFirstAttach() {
                super.onAfterFirstAttach();
                Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
                    @Override
                    public void execute() {
                        loader.load();
                    }
                });
            }
        };
        view.getView().setForceFit(true);
        view.setLoadMask(true);
        view.setLoader(loader);


        // Create the filters, and hook them to the loader and grid
        GridFilters<EmployeeProxy> filters = new GridFilters<EmployeeProxy>(loader);
        filters.initPlugin(view);
        filters.setLocal(false);//be sure to be remote, or it will affect the local cached data only
        filters.addFilter(new StringFilter<EmployeeProxy>(props.department()));
        filters.addFilter(new StringFilter<EmployeeProxy>(props.displayName()));
        filters.addFilter(new StringFilter<EmployeeProxy>(props.password()));
        filters.addFilter(new StringFilter<EmployeeProxy>(props.userName()));

        FramedPanel cp = new FramedPanel();
        cp.setHeadingText("RequestFactory Grid Example");
        cp.setPixelSize(500, 400);
//        cp.addStyleName("margin-10");

        VerticalLayoutContainer con = new VerticalLayoutContainer();
        con.setBorders(true);
        con.add(view, new VerticalLayoutContainer.VerticalLayoutData(1, 1));
        con.add(toolBar, new VerticalLayoutContainer.VerticalLayoutData(1, -1));
        cp.setWidget(con);
        con.add(textButton);

        return cp;


    }

}