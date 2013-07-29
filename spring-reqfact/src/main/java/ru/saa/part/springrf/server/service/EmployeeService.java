package ru.saa.part.springrf.server.service;

import ru.saa.part.springrf.server.domain.Employee;

/**
 * $Revision:  $
 * $Author: shleger $
 * $Date: 25.07.13 17:07  $
 */
public interface EmployeeService {

    public Employee findEmployee(long employeeId);

    public void persist(Employee employeeDTO);
}
