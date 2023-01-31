package com.nextgenpos.nextgenpos.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Category {
    private Long idCategory;

    private String name;

    private Collection<Product> products;

    public Category() {
    }

    public Category(Long idCategory, String name, Collection<Product> products) {
        this.idCategory = idCategory;
        this.name = name;
        this.products = products;
    }

    @Id
    @GeneratedValue
    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }
}
