package ru.saa.part.springrf.server.domain;


import ru.saa.part.springrf.server.locator.spring.HasVersionAndId;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee implements HasVersionAndId{

    private String userName;

    private String department;

    private String displayName;

    private String password;

    @OneToMany(mappedBy = "employee")
    private List<Job> jobs;

    @JoinColumn
    private Long supervisorKey;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(name = "version")
    private Long version;

    @Transient
    private Employee supervisor;

    public String getDepartment() {
        return department;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getSupervisorKey() {
        return supervisorKey;
    }

    public void setSupervisorKey(Long supervisorKey) {
        this.supervisorKey = supervisorKey;
    }

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

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }


    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "userName='" + userName + '\'' +
                ", department='" + department + '\'' +
                ", displayName='" + displayName + '\'' +
                ", password='" + password + '\'' +
                ", supervisorKey=" + supervisorKey +
                ", id=" + id +
                ", version=" + version +
                ", supervisor=" + supervisor +
                '}';
    }

}