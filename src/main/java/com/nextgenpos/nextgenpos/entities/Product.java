package com.nextgenpos.nextgenpos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Collection;

@Entity
public class Product {
    private Long idProduct;
    private String productName;
    private Integer quantity;
    private Double price;
    private String description;
    private String provider;

    private Collection<ItemSale> itemSales;

    public Product(Long idProduct, String productName, Integer quantity, Double price, String description, String provider) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.provider = provider;
    }

    public Product() {

    }

    @Id
    @GeneratedValue
    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }


    @OneToMany(mappedBy = "product")
    public Collection<ItemSale> getItemSales() {
        return itemSales;
    }

    public void setItemSales(Collection<ItemSale> itemSale) {
        this.itemSales = itemSale;
    }

}
