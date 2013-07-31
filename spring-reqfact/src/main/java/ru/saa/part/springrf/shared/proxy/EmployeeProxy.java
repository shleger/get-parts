package ru.saa.part.springrf.shared.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import ru.saa.part.springrf.server.domain.Employee;
import ru.saa.part.springrf.server.locator.spring.GWTSpringEntityLocator;

import java.util.List;

@ProxyFor(value = Employee.class, locator = GWTSpringEntityLocator.class)
public interface EmployeeProxy extends EntityProxy {

    String getDepartment();

    String getDisplayName();

    Long getId();

    String getPassword();

    EmployeeProxy getSupervisor();

    String getUserName();

    List<JobProxy> getJobs();

    void setDepartment(String department);

    void setDisplayName(String displayName);

    void setPassword(String password);

    void setSupervisor(EmployeeProxy supervisor);

    void setUserName(String userName);

     void setJobs(List<JobProxy> jobs);

}