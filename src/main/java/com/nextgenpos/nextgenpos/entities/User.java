package com.nextgenpos.nextgenpos.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class User {
    private Long idUser;
    private String username;
    private String password;
    private Person person;
    private Collection<Sale> sales;
    private String typeEmployee;
    private boolean isActive;

    public User(Long idUser, String username, String password, String typeEmployee, boolean isActive) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.typeEmployee = typeEmployee;
        this.isActive = isActive;
    }

    public User() {

    }

    @Id
    @GeneratedValue
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeEmployee() {
        return typeEmployee;
    }

    public void setTypeEmployee(String typeEmployee) {
        this.typeEmployee = typeEmployee;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    public Collection<Sale> getSales() {
        return sales;
    }

    public void setSales(Collection<Sale> sales) {
        this.sales = sales;
    }

    public void addSale(Sale sale) {
        this.getSales().add(sale);
    }

    @OneToOne
    public Person getPerson() {
        return person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
}
