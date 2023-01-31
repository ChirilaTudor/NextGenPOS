package com.nextgenpos.nextgenpos.entities;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Person {
    private Long idPerson;
    private String firstName;
    private String lastName;
    private String address;
    private String CNP;
    private Date birthDate;
    private String phoneNumber;
    private User user;


    public Person(Long idPerson, String firstName, String lastName, String address, String CNP, Date birthDate, String phoneNumber) {
        this.idPerson = idPerson;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.CNP = CNP;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    public Person() {

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setIdPerson(Long id) {
        this.idPerson = id;
    }

    @Id
    @GeneratedValue
    public Long getIdPerson() {
        return idPerson;
    }

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
