package ru.saa.part.springrf.shared.services;

import com.google.web.bindery.requestfactory.shared.*;
import com.sencha.gxt.data.shared.SortInfo;
import com.sencha.gxt.data.shared.loader.FilterConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import ru.saa.part.springrf.server.locator.spring.GWTSpringServiceLocator;
import ru.saa.part.springrf.server.service.EmployeePagingBean;
import ru.saa.part.springrf.server.service.EmployeeService;
import ru.saa.part.springrf.shared.proxy.EmployeeProxy;
import ru.saa.part.springrf.shared.proxy.JobProxy;

import java.util.List;

/**
 * $Revision:  $
 * $Author: shleger $
 * $Date: 31.07.13 14:29  $
 */
@Service(value = EmployeeService.class, locator = GWTSpringServiceLocator.class)
public interface EmployeeRequest extends RequestContext {
    Request<EmployeeProxy> findEmployee(long id);

    Request<JobProxy> findJob(long id);

    Request<Void> persist(EmployeeProxy employeeProxy);

    @ProxyFor(EmployeePagingBean.class)
    public interface EmployeePagingProxy extends ValueProxy, PagingLoadResult<EmployeeProxy> {
        @Override
        public List<EmployeeProxy> getData();
    }


    Request<EmployeePagingProxy> getEmployees(int offset, int limit, List<SortInfo> sortInfo, List<FilterConfig> filterConfig);

}

