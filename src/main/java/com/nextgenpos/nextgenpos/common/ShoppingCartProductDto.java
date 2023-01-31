package com.nextgenpos.nextgenpos.common;

public class ShoppingCartProductDto {
    private Long idProduct;
    private String productName;
    private Integer quantity;
    private Double price;

    public ShoppingCartProductDto(Long idProduct, String productName, Integer quantity, Double price) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
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

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }
}
