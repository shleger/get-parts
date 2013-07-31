package ru.saa.part.springrf.server.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.saa.part.springrf.server.domain.Employee;

/**
 * Created with IntelliJ IDEA.
 * User: saa
 * Date: 7/31/13
 * Time: 21:39 PM
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext-test.xml")
public class EmployeeServiceImplTest {

    @Autowired
    EmployeeService employeeService;

    @Test
    public void testFindEmployee() throws Exception {

    }

    @Test
    public void testPersist() throws Exception {

        Employee emp = new Employee();
        emp.setDepartment("testDep");
        emp.setDisplayName("testDispName");


        employeeService.persist(emp);

    }

    @Test
    public void testGetEmployees() throws Exception {

    }
}
