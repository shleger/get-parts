package ru.saa.parts.gwt.server.domain;

import com.google.web.bindery.requestfactory.shared.Locator;
import ru.saa.parts.gwt.server.domain.Data;

/**
 * Created with IntelliJ IDEA.
 * User: saa
 * Date: 12/20/12
 * Time: 03:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class EntityLocator extends Locator<Data,Long>{
    @Override
    public Data create(Class<? extends Data> aClass) {
        return new Data();  
    }

    @Override
    public Data find(Class<? extends Data> aClass, Long aLong) {
        return null;      //todo rm null
    }

    @Override
    public Class<Data> getDomainType() {
        return Data.class;  
    }

    @Override
    public Long getId(Data data) {
        return data.getId();  
    }

    @Override
    public Class<Long> getIdType() {
        return Long.class;  
    }

    @Override
    public Object getVersion(Data data) {
        return data.getVersion();  
    }
}
