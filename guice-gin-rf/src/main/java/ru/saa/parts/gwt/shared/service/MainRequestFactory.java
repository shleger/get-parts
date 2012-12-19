package ru.saa.parts.gwt.shared.service;

import com.google.web.bindery.requestfactory.shared.*;
import ru.saa.parts.gwt.server.dao.DataDao;
import ru.saa.parts.gwt.shared.proxy.DataProxy;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 19.12.12
 * Time: 18:04
 * To change this template use File | Settings | File Templates.
 */
public interface MainRequestFactory extends RequestFactory {

    @Service(value = DataDao.class, locator = EntityServiceLocator.class )
    public  interface DataContext extends RequestContext{

        Request<DataProxy> getData();

    }


    DataContext dataContext();

}
