package ru.saa.part.onlyrf.server.domain;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
public class Employee {

//    @Size(min = 3, max = 30)    //todo enable validation
    private String userName;

    private String department;

    @NotNull
    private String displayName;

    private String password;

    @JoinColumn
    private Long supervisorKey;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(name = "version")
    private Integer version;

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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }
}