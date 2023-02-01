package com.nextgenpos.nextgenpos.ejb;

import com.nextgenpos.nextgenpos.common.ProductDto;
import com.nextgenpos.nextgenpos.common.ShoppingCartProductDto;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Stateful
@SessionScoped
public class ShoppingCartBean implements Serializable {
    List<ShoppingCartProductDto> shoppingCart = new ArrayList<>();

    public List<ShoppingCartProductDto> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<ShoppingCartProductDto> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void removeAllProductsFromShoppingCart() {
        this.shoppingCart.removeAll(this.shoppingCart);
    }
}
