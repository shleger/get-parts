package ru.saa.part.springrf.server.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.saa.part.springrf.server.domain.Employee;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * $Revision:  $
 * $Author: shleger $
 * $Date: 25.07.13 17:08  $
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{


    @PostConstruct
    public void init() throws Exception {
    }

    @PreDestroy
    public void destroy() {
    }

    public Employee findEmployee(long employeeId) {

        Employee em3 = new Employee();
        em3.setUserName("name3");
        em3.setVersion(3L);
        em3.setId(3L);

        return em3;

    }

    @Transactional(propagation= Propagation.REQUIRED, rollbackFor=Exception.class)
    public void persist(Employee employeeDTO) {
        System.out.println("SAVED ENTITY" + employeeDTO);
    }

}
