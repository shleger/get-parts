package ru.saa.part.springrf.shared.services;


import com.google.web.bindery.requestfactory.shared.*;
import ru.saa.part.springrf.server.locator.spring.GWTSpringServiceLocator;
import ru.saa.part.springrf.server.service.EmployeeService;
import ru.saa.part.springrf.shared.proxy.EmployeeProxy;

public interface ExpensesRequestFactory extends RequestFactory {

    EmployeeRequest employeeRequest();


    @Service(value = EmployeeService.class, locator = GWTSpringServiceLocator.class)
    public interface EmployeeRequest extends RequestContext {
        Request<EmployeeProxy> findEmployee(long id);
        Request<Void> persist(EmployeeProxy employeeProxy);
    }

}
