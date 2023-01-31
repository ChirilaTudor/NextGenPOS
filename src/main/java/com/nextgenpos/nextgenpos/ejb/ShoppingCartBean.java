package com.nextgenpos.nextgenpos.ejb;

import com.nextgenpos.nextgenpos.common.ProductDto;
import com.nextgenpos.nextgenpos.common.ShoppingCartProductDto;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class ShoppingCartBean {
    List<ShoppingCartProductDto> shoppingCart = new ArrayList<>();

    @Inject
    ProductsBean productsBean;

    public List<ShoppingCartProductDto> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<ShoppingCartProductDto> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void removeAllProductsFromShoppingCart() {
        this.shoppingCart.removeAll(this.shoppingCart);
    }

    public void addProductIntoShoppingCart(long productId) {

        try {
        ProductDto productDto = productsBean.findById(productId);
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto(
                productDto.getIdProduct(),
                productDto.getProductName(),
                1,
                productDto.getPrice());

        this.shoppingCart.add(shoppingCartProductDto);

        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public void editProductQuantityInShoppingCart(Integer indexProduct, String upDown){
        List<ShoppingCartProductDto> shoppingCart = this.shoppingCart;

        int newQuantity;

        switch (upDown){
            case "up":
                newQuantity = shoppingCart.get(indexProduct).getQuantity() + 1;
                shoppingCart.get(indexProduct).setQuantity(newQuantity);
                break;
            case "down":
                newQuantity = shoppingCart.get(indexProduct).getQuantity() - 1;
                shoppingCart.get(indexProduct).setQuantity(newQuantity);
                break;
            default: break;
        }
    }
}
