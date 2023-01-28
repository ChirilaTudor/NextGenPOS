package com.nextgenpos.nextgenpos.ejb;

import com.nextgenpos.nextgenpos.common.ShoppingCartProductDto;
import jakarta.ejb.Stateless;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class ShoppingCartBean {
    List<ShoppingCartProductDto> shoppingCart = new ArrayList<>();

    public List<ShoppingCartProductDto> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<ShoppingCartProductDto> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void removeAllProductsFromShoppingCart(){
        this.shoppingCart.removeAll(this.shoppingCart);
    }
}
