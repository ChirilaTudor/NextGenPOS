package com.nextgenpos.nextgenpos.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;

@Entity
public class Sale {
    private Long idSale;
    private Date saleDate;
    private User user;
    private Double total;

    private Collection<ItemSale> itemSales;

    public Sale(Long idSale, Date saleDate, Double total) {
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

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }


    @OneToMany(mappedBy = "sale")
    public Collection<ItemSale> getItemSales() {
        return itemSales;
    }

    public void setItemSales(Collection<ItemSale> itemSales) {
        this.itemSales = itemSales;
    }

    public void addItemSale(ItemSale itemSale) {
        this.getItemSales().add(itemSale);
    }
}
