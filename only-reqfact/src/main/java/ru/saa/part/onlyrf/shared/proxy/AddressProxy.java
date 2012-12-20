package ru.saa.part.onlyrf.shared.proxy;

import com.google.web.bindery.requestfactory.shared.ValueProxy;

public interface AddressProxy extends ValueProxy {
    public String getStreet1();
    public String getStreet2();
    public String getCity();
    public String getSt();
    public String getZip();
}