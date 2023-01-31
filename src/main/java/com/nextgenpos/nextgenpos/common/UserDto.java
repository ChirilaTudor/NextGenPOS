package com.nextgenpos.nextgenpos.common;

import com.nextgenpos.nextgenpos.entities.Person;
import com.nextgenpos.nextgenpos.entities.Sale;

import java.util.Collection;

public class UserDto {
    private Long idUser;
    private String username;
    private String password;
    private Person person;
    private Boolean isActive;
    public UserDto(Long idUser, String username, String password, Person person, Boolean isActive) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.person = person;
        this.isActive = isActive;
    }

    public Long getIdUser() {
        return idUser;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Person getPerson() {
        return person;
    }

    public Boolean getActive() {
        return isActive;
    }

}
