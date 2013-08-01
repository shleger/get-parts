package ru.saa.part.springrf.server.service;

import com.sencha.gxt.data.shared.SortInfoBean;
import com.sencha.gxt.data.shared.loader.FilterConfigBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.saa.part.springrf.server.domain.Employee;
import ru.saa.part.springrf.server.domain.Job;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import java.util.List;

/**
 * $Revision:  $
 * $Author: shleger $
 * $Date: 25.07.13 17:08  $
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {


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

    @Override
    public Job findJob(long employeeId) {
        return entityManager.find(Job.class,employeeId);
    }

    @Transactional
    public void persist(Employee employeeDTO) {
        entityManager.persist(employeeDTO);
        System.out.println("SAVED ENTITY: " + employeeDTO);
    }

    @Override
    public EmployeePagingBean getEmployees(int offset, int limit, List<SortInfoBean> sortInfo, List<FilterConfigBean> filterConfig) {


        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        EntityType<Employee> Employee_ = entityManager.getMetamodel().entity(Employee.class);


        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> cFrom = cq.from(Employee.class);



        for (SortInfoBean sort : sortInfo)
            switch (sort.getSortDir()) {
                case ASC:
                    cq.orderBy(cb.asc(cFrom.get(sort.getSortField())));
                    break;
                case DESC:
                    cq.orderBy(cb.desc(cFrom.get(sort.getSortField())));
                    break;
            }



        for (FilterConfigBean filter : filterConfig){

            Expression<String> literal = cb.upper(cb.literal("*" + filter.getValue() + "*"));
            Path<String> idPath = cFrom.get( filter.getField() );
            Predicate predicate = cb.like(idPath, literal);

            cq.where(predicate);
        }


        Query qCount = entityManager.createQuery("select count (*) from Employee ");
        Long count = (Long) qCount.getSingleResult();

        TypedQuery<Employee> q = entityManager.createQuery(cq);

        q.setMaxResults(limit);
        q.setFirstResult(offset);
        List<Employee> l = q.getResultList();
        return new EmployeePagingBean(l, count.intValue(), offset);
    }

}
