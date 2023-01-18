package com.nextgenpos.nextgenpos.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Sale {
    private Long idSale;
    private String saleDate;
    private User user;
    private Float total;


    private Collection<ItemSale> itemSales;


    public Sale(Long idSale, String saleDate, Float total) {
        this.idSale = idSale;
        this.saleDate = saleDate;
        this.total = total;
    }

    public Sale() {

    }

    @Id
    @GeneratedValue
    public Long getIdSale() {
        return idSale;
    }

    public void setIdSale(Long idSale) {
        this.idSale = idSale;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }


    @OneToMany(mappedBy = "sale")
    public Collection<ItemSale> getItemSales() {
        return itemSales;
    }

    public void setItemSales(Collection<ItemSale> itemSales) {
        this.itemSales = itemSales;
    }
}
