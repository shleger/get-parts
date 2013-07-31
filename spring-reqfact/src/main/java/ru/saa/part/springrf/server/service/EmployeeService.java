package ru.saa.part.springrf.server.service;

import com.sencha.gxt.data.shared.SortInfoBean;
import com.sencha.gxt.data.shared.loader.FilterConfigBean;
import ru.saa.part.springrf.server.domain.Employee;

import java.util.List;

/**
 * $Revision:  $
 * $Author: shleger $
 * $Date: 25.07.13 17:07  $
 */
public interface EmployeeService {

    public Employee findEmployee(long employeeId);

    public void persist(Employee employeeDTO);

    public EmployeePagingBean getEmployees(int offset, int limit, List<SortInfoBean> sortInfo, List<FilterConfigBean> filterConfig);
}
