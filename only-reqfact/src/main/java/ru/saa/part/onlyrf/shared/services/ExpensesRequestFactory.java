package ru.saa.part.onlyrf.shared.services;


import com.google.web.bindery.requestfactory.shared.*;
import ru.saa.part.onlyrf.server.dao.EmployeeDao;
import ru.saa.part.onlyrf.server.domain.Employee;
import ru.saa.part.onlyrf.server.locator.MyServiceLocator;
import ru.saa.part.onlyrf.shared.proxy.EmployeeProxy;

import java.util.List;

public interface ExpensesRequestFactory extends RequestFactory {

    @Service(value = EmployeeDao.class, locator = MyServiceLocator.class)
    public interface EmployeeRequest extends RequestContext {

//        Request<Long> countEmployees();
//
//        Request<Long> countEmployeesByDepartment(
//                String department);

        Request<List<EmployeeProxy>> findAllEmployees();

        Request<EmployeeProxy> findEmployee(Long id);

//        Request<List<EmployeeProxy>> findEmployeeEntries(int firstResult,
//                                                         int maxResults);
//
//        Request<List<EmployeeProxy>> findEmployeeEntriesByDepartment(
//                String department, int firstResult, int maxResults);

        InstanceRequest<EmployeeProxy, Void> persist();

        InstanceRequest<EmployeeProxy, Void> remove();

    }

    EmployeeRequest employeeRequest();

//    ExpenseRequest expenseRequest();
//
//    ReportRequest reportRequest();

}
