package ru.saa.part.springrf.shared.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import ru.saa.part.springrf.server.domain.Job;

@ProxyFor(Job.class)
public interface JobProxy extends EntityProxy {
    Long getId();
    Long getVersion();
    String getFirstName();
    String getLastName();
    AddressProxy getAddress();
    EmployeeProxy getEmployee();

    void setFirstName(String firstName);
    void setLastName( String lastName);
    void setAddress(AddressProxy address);

}
