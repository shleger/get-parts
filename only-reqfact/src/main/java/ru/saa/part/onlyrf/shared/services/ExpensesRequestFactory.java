package ru.saa.part.onlyrf.shared.services;


import com.google.web.bindery.requestfactory.shared.*;
import ru.saa.part.onlyrf.server.dao.EmployeeDao;
import ru.saa.part.onlyrf.server.locator.MyServiceLocator;
import ru.saa.part.onlyrf.shared.proxy.EmployeeProxy;

import java.util.List;

public interface ExpensesRequestFactory extends RequestFactory {

    @Service(value = EmployeeDao.class, locator = MyServiceLocator.class)
    public interface EmployeeRequest extends RequestContext {

        Request<List<EmployeeProxy>> findAllEmployees();

        Request<EmployeeProxy> findEmployee(Long id);

        Request<Void> persist(EmployeeProxy employee);

        Request<Void> remove(EmployeeProxy employee);

        Request<Void> update(EmployeeProxy employee);

    }

    EmployeeRequest employeeRequest();


//    ExpenseRequest expenseRequest();
//
//    ReportRequest reportRequest();

}
