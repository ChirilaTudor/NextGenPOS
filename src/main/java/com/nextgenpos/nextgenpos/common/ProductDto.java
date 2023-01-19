package com.nextgenpos.nextgenpos.common;

public class ProductDto {
    private Long idProduct;
    private String productName;
    private Integer quantity;
    private Float price;
    private String description;
    private String provider;

    public ProductDto(Long idProduct, String productName, Integer quantity, Float price, String description, String provider) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.provider = provider;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getProvider() {
        return provider;
    }
}
