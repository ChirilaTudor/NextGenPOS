package com.nextgenpos.nextgenpos.common;

import java.util.Date;

public class PersonDto {
    private Long idPerson;
    private String firstName;
    private String lastName;
    private String address;
    private String CNP;
    private Date birthDate;
    private String phoneNumber;

    public PersonDto(Long idPerson, String firstName, String lastName, String address, String CNP, Date birthDate, String phoneNumber) {
        this.idPerson = idPerson;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.CNP = CNP;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCNP() {
        return CNP;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
