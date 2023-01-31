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
            List<ShoppingCartProductDto> shoppingCart = this.shoppingCart;

            for(ShoppingCartProductDto product : shoppingCart) {
                if(product.getIdProduct() == productId) {
                    return;
                }
            }

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

    public void editProductQuantityInShoppingCart(Long productId, String upDown){
        List<ShoppingCartProductDto> shoppingCart = this.shoppingCart;

        int newQuantity = 0, indexCurrentProduct = 0;
        double newPrice;

        ProductDto productDto = productsBean.findById(productId);

        int indexAux = 0;
        for(ShoppingCartProductDto product : shoppingCart) {
            if(product.getIdProduct() == productId) {
                indexCurrentProduct = indexAux;
            }
            indexAux++;
        }

        switch (upDown){
            case "up":
                newQuantity = shoppingCart.get(indexCurrentProduct).getQuantity() + 1;
                shoppingCart.get(indexCurrentProduct).setQuantity(newQuantity);
                newPrice = productDto.getPrice() * newQuantity;
                shoppingCart.get(indexCurrentProduct).setPrice(newPrice);
                break;
            case "down":
                newQuantity = shoppingCart.get(indexCurrentProduct).getQuantity() - 1;
                if(newQuantity == 0){
                    break;
                }
                shoppingCart.get(indexCurrentProduct).setQuantity(newQuantity);
                newPrice = productDto.getPrice() * newQuantity;
                shoppingCart.get(indexCurrentProduct).setPrice(newPrice);
                break;
            default: break;
        }
    }

    public void removeProductFromShoppingCart(Long productId) {
        List<ShoppingCartProductDto> shoppingCart = this.shoppingCart;

        int indexCurrentProduct = 0;

        int indexAux = 0;
        for(ShoppingCartProductDto product : shoppingCart) {
            if(product.getIdProduct() == productId) {
                indexCurrentProduct = indexAux;
            }
            indexAux++;
        }

        shoppingCart.remove(indexCurrentProduct);
    }
}
