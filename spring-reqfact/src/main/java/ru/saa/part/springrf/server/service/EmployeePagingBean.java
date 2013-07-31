package ru.saa.part.springrf.server.service;

import com.sencha.gxt.data.shared.loader.PagingLoadResultBean;
import ru.saa.part.springrf.server.domain.Employee;

import java.util.List;

/**
 * $Revision:  $
 * $Author: shleger $
 * $Date: 31.07.13 15:15  $
 */
public class EmployeePagingBean extends PagingLoadResultBean<Employee> {
    protected EmployeePagingBean() {

    }
    public EmployeePagingBean(List<Employee> list, int totalLength, int offset) {
        super(list, totalLength, offset);
    }
}
