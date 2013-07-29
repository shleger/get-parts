package ru.saa.part.springrf.server.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.saa.part.springrf.server.domain.Employee;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * $Revision:  $
 * $Author: shleger $
 * $Date: 25.07.13 17:08  $
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{


    @PersistenceContext
    EntityManager entityManager;


    @PostConstruct
    public void init() throws Exception {
    }

    @PreDestroy
    public void destroy() {
    }

    @Transactional
    public Employee findEmployee(long employeeId) {

        List<Employee> l = entityManager.createQuery("from Employee").getResultList();



        Employee em3 = new Employee();

        em3.setUserName("name3 [stub]" + l);
        em3.setVersion(3L);
        em3.setId(3L);

        return em3;

    }

    @Transactional
    public void persist(Employee employeeDTO) {
        entityManager.persist(employeeDTO);
        System.out.println("SAVED ENTITY: " + employeeDTO);
    }

}
