package ru.saa.part.onlyrf.server.dao;

import ru.saa.part.onlyrf.server.domain.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 20.12.12
 * Time: 18:03
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeDao {


    public List<Employee> findAllEmployees() {

        Employee em1 = new Employee();
        em1.setUserName("name1");
        em1.setVersion(1);
        em1.setId(1L);

        Employee em2 = new Employee();
        em2.setUserName("name2");
        em2.setVersion(2);
        em2.setId(2L);

        List<Employee> employees = new ArrayList<Employee>();

        employees.add(em1);
        employees.add(em2);

        return employees;

    }

    public Employee findEmployee(Long id) {

        Employee em3 = new Employee();
        em3.setUserName("name3");
        em3.setVersion(3);
        em3.setId(3L);

        return em3;
    }


    public void update(Employee employee) {

        System.out.println("Employee saved: " + employee);


    }
    public void persist() {

    }

    public void remove() {
    }
}
