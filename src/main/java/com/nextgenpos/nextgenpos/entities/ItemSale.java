package com.nextgenpos.nextgenpos.entities;
import jakarta.persistence.*;

@Entity
public class ItemSale {
    private Long idItemSale;

    private Product product;

    private ItemReturn itemReturn;

    private Sale sale;
    private Integer quantity;
    private Double pricePerUnit;

    public ItemSale(Long idItemSale, Integer quantity, Double pricePerUnit) {
        this.idItemSale = idItemSale;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public ItemSale() {

    }

    @Id
    @GeneratedValue
    public Long getIdItemSale() {
        return idItemSale;
    }

    public void setIdItemSale(Long idItemSale) {
        this.idItemSale = idItemSale;
    }


    @ManyToOne()
    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @OneToOne(mappedBy = "itemSale", cascade = CascadeType.ALL)
    public ItemReturn getItemReturn() {
        return itemReturn;
    }

    public void setItemReturn(ItemReturn itemReturn) {
        this.itemReturn = itemReturn;
    }

    @ManyToOne
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
