package ru.saa.part.springrf.server.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.saa.part.springrf.server.domain.Employee;
import ru.saa.part.springrf.server.domain.Job;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

        System.out.println("-----------testPersist---------------");

        Random random = new Random();
        final int RND_MAX = 99;


        Employee emp = new Employee();
        emp.setDepartment("testDep");
        emp.setDisplayName("testDispName");

        List<Job> jobs = new ArrayList<Job>();
        Job job =  new Job();
        job.setEmployee(emp);
        job.setFirstName("first Job" + random.nextInt(RND_MAX));
        job.setLastName("last Job" + random.nextInt(RND_MAX));
        jobs.add(job);

        emp.setJobs(jobs); ///TODO same err:   javax.persistence.PersistenceException: org.hibernate.exception.ConstraintViolationException: NULL not allowed for column "EMPLOYEE_ID"; SQL statement:



        employeeService.persist(emp);

    }

    @Test
    public void testGetEmployees() throws Exception {

    }
}
