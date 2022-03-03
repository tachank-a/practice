package com.example.finalproject.entity;

import javax.persistence.*;
import java.sql.Date;

import java.util.Set;


@Entity
@Table(name = "INSURED_PERSONS")
public class InsuredPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String fullName;

    private Date dob;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;

    @ManyToMany
    @JoinTable(name = "insured_persons_options",
            joinColumns = @JoinColumn(name = "insured_person_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "option_id", referencedColumnName = "id"))
    private Set<Option> options;

    public InsuredPerson() {}



    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}