package ru.saa.part.springrf.shared.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import ru.saa.part.springrf.server.domain.Person;

@ProxyFor(Person.class)
public interface PersonProxy extends EntityProxy {
    Long getId();
    Integer getVersion();
    String getFirstName();
    String getLastName();
    AddressProxy getAddress();
}
