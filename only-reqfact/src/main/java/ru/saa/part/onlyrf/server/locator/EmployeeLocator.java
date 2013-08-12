package ru.saa.part.onlyrf.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;
import ru.saa.part.onlyrf.server.domain.Employee;

/**
 * Created with IntelliJ IDEA.
 * User: saa
 * Date: 12/21/12
 * Time: 01:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeLocator extends Locator<Employee,Long> {
    @Override
    public Employee create(Class<? extends Employee> clazz) {
        return new Employee();
    }

    @Override
    public Employee find(Class<? extends Employee> clazz, Long id) {
        return null;       //TODO fill it with true val
    }

    @Override
    public Class<Employee> getDomainType() {
        return Employee.class;
    }

    @Override
    public Long getId(Employee domainObject) {
        return domainObject.getId();
    }

    @Override
    public Class<Long> getIdType() {
        return null;  
    }

    @Override
    public Object getVersion(Employee domainObject) {
        return domainObject.getVersion();
    }
}
