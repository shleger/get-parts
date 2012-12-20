package ru.saa.part.onlyrf.shared.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import ru.saa.part.onlyrf.server.domain.Employee;

@ProxyFor(Employee.class)
public interface EmployeeProxy extends EntityProxy {

    String getDepartment();

    String getDisplayName();

    Long getId();

    String getPassword();

    EmployeeProxy getSupervisor();

    String getUserName();

    void setDepartment(String department);

    void setDisplayName(String displayName);

    void setPassword(String password);

    void setSupervisor(EmployeeProxy supervisor);

    void setUserName(String userName);
}