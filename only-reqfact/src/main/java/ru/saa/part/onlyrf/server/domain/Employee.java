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

}