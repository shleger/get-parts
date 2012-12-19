package ru.saa.parts.gwt.shared.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import ru.saa.parts.gwt.server.domain.Data;
import ru.saa.parts.gwt.server.domain.EntityLocator;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 19.12.12
 * Time: 17:51
 * To change this template use File | Settings | File Templates.
 */

@ProxyFor (value = Data.class,locator = EntityLocator.class)
public interface DataProxy extends EntityProxy {

    String getName();

    void setName(String name);

    String getDescr();

    void setDescr(String descr);

    Long getVersion();

    void setVersion(Long version);

    Long getId();

    void setId(Long id);
}
