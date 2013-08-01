package ru.saa.part.springrf.server.domain;

import ru.saa.part.springrf.server.locator.spring.HasVersionAndId;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 20.12.12
 * Time: 17:45
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Job implements HasVersionAndId {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;
    private String firstName;
    private String  lastName;


    @ManyToOne(optional = false)    // TODO:  NULL not allowed for column "EMPLOYEE_ID"; SQL statement  !!!
    private Employee employee;

    @Embedded
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * suppress exception:
     * com.google.web.bindery.requestfactory.server.UnexpectedException: Could not find static method with a single parameter of a key type
     * @param id
     * @return
     */
    public static Job findJob(Long id){
        return null;
    }
}
