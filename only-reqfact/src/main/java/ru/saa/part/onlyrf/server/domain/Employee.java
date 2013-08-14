package ru.saa.part.onlyrf.server.domain;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
public class Employee  extends DataStoreObject{

//    @Size(min = 3, max = 30)    //todo enable validation
    private String userName;

    private String department;

    @NotNull
    private String displayName;

    private String password;

    @JoinColumn
    private Long supervisorKey;

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


    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisorKey(Long supervisorKey) {
        this.supervisorKey = supervisorKey;
    }

    public Long getId() {
        return id;
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

//    public static Employee findEmployee(Long id){
//        return  new Employee();
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!id.equals(employee.id)) return false;
        if (!userName.equals(employee.userName)) return false;
        if (!version.equals(employee.version)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + version.hashCode();
        return result;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                "version='" + version + '\'' +
                "userName='" + userName + '\'' +
                ", department='" + department + '\'' +
                ", displayName='" + displayName + '\'' +
                ", password='" + password + '\'' +
                ", supervisorKey=" + supervisorKey +
                ", supervisor=" + supervisor +
                '}';
    }
}