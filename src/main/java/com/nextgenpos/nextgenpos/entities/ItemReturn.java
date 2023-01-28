package com.nextgenpos.nextgenpos.entities;
import jakarta.mail.FetchProfile;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class ItemReturn {
    private Long idReturn;
    private Integer quantity;
    private Date returnDate;

    private ItemSale itemSale;

    public ItemReturn(Long idReturn, Integer quantity, Date returnDate) {
        this.idReturn = idReturn;
        this.quantity = quantity;
        this.returnDate = returnDate;
    }

    public ItemReturn() {

    }

    @Id
    @GeneratedValue
    public Long getIdReturn() {
        return idReturn;
    }

    public void setIdReturn(Long idReturn) {
        this.idReturn = idReturn;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @OneToOne
    public ItemSale getItemSale() {
        return itemSale;
    }

    public void setItemSale(ItemSale itemSale) {
        this.itemSale = itemSale;
    }
}
