package ru.saa.part.onlyrf.server.dao;

import ru.saa.part.onlyrf.server.domain.Employee;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 20.12.12
 * Time: 18:03
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeDao {


    static Map<Long, Employee> db = new LinkedHashMap<Long, Employee>();

    static {

        Employee em1 = new Employee();
        em1.setUserName("name1");
        em1.setVersion(1);
        em1.setId(1L);

        Employee em2 = new Employee();
        em2.setUserName("name2");
        em2.setVersion(2);
        em2.setId(2L);

        Employee em3 = new Employee();
        em3.setUserName("name3");
        em3.setVersion(3);
        em3.setId(3L);

        db.put(em1.getId(), em1);
        db.put(em2.getId(), em2);
        db.put(em3.getId(), em3);
    }


    public List<Employee> findAllEmployees() {
        return new ArrayList<Employee>(db.values());
    }


    public Employee findEmployee(Long id) {
        return db.get(id);
    }


    public void update(Employee employee) {
        db.put(employee.getId(), employee);
    }


    public void persist(Employee  employee) {
        db.put(employee.getId(), employee);
    }

    public void remove(Employee  employee) {
        db.remove(employee.getId());
    }
}
