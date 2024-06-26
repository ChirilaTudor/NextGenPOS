package com.nextgenpos.nextgenpos.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Product {
    private Long idProduct;
    private String productName;
    private Integer quantity;
    private Double price;
    private String description;
    private String provider;
    private ProductPhoto productPhoto;
    private Collection<ItemSale> itemSales;
    private Category category;

    public Product(Long idProduct, String productName, Integer quantity, Double price, String description, String provider) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.provider = provider;
    }

    public Product() {
        this.itemSales = new ArrayList<>();
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

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public ProductPhoto getProductPhoto() {
        return productPhoto;
    }

    public void setProductPhoto(ProductPhoto productPhoto) {
        this.productPhoto = productPhoto;
    }

    @OneToMany(mappedBy = "product")
    public Collection<ItemSale> getItemSales() {
        return itemSales;
    }

    public void setItemSales(Collection<ItemSale> itemSale) {
        this.itemSales = itemSale;
    }

    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void addItemSale(ItemSale itemSale) {
        this.getItemSales().add(itemSale);
    }

}
