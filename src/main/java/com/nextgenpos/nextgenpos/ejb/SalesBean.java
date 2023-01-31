package com.nextgenpos.nextgenpos.ejb;

import com.nextgenpos.nextgenpos.common.ProductDto;
import com.nextgenpos.nextgenpos.common.ShoppingCartProductDto;
import com.nextgenpos.nextgenpos.entities.ItemSale;
import com.nextgenpos.nextgenpos.entities.Product;
import com.nextgenpos.nextgenpos.entities.Sale;
import com.nextgenpos.nextgenpos.entities.User;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Stateless
public class SalesBean {
    private static final Logger LOG = Logger.getLogger(ProductsBean.class.getName());

    @Inject
    ShoppingCartBean shoppingCartBean;

    @PersistenceContext
    EntityManager entityManager;

    public void createSale(long userId){
        LOG.info("createSale");

        if(!shoppingCartBean.getShoppingCart().isEmpty()) {

            try {
                User user = entityManager.find(User.class, userId);
                Sale sale = new Sale();
                Date today = new Date();
                sale.setSaleDate(today);
                sale.setUser(user);
                user.addSale(sale);
                entityManager.persist(sale);

                List<ShoppingCartProductDto> shoppingCart = shoppingCartBean.getShoppingCart();
                double total = 0.0;

                for (ShoppingCartProductDto productDto: shoppingCart){
                    ItemSale itemSale = new ItemSale();
                    itemSale.setSale(sale);
                    itemSale.setQuantity(productDto.getQuantity());
                    itemSale.setPricePerUnit(productDto.getPrice());
                    Product product = entityManager.find(Product.class, productDto.getIdProduct());
                    itemSale.setProduct(product);
                    entityManager.persist(itemSale);
                    sale.addItemSale(itemSale);

                    total += (productDto.getQuantity() * productDto.getPrice());
                }

                sale.setTotal(total);
                entityManager.persist(sale);

            } catch (Exception ex) {
                throw new EJBException(ex);
            }
        }
    }

    public List<ItemSale> findAllItemSales(){
        try{
            LOG.info("findAllItemSales");
            TypedQuery<ItemSale> typedQuery = entityManager.createQuery("SELECT i from ItemSale i", ItemSale.class);
            List<ItemSale> itemSales= typedQuery.getResultList();
            return itemSales;
        }
        catch (Exception ex){
            throw new EJBException(ex);
        }
    }


    public List<Sale> findSalesBetween(Date startDate, Date endDate){
        try{
            LOG.info("findSalesBetween");
            TypedQuery<Sale> typedQuery = entityManager.createQuery("SELECT s from Sale s ", Sale.class);
            List<Sale> sales= typedQuery.getResultList();
            return sales.stream().filter(sale -> sale.getSaleDate().after(startDate)).filter(sale-> sale.getSaleDate().before(endDate)).collect(Collectors.toList());
        }
        catch (Exception ex){
            throw new EJBException(ex);
        }
    }
    public List<ItemSale> findProductSales(Long productId){
        try{
            LOG.info("findSalesBetween");
            TypedQuery<ItemSale> typedQuery = entityManager.createQuery("SELECT i from ItemSale i", ItemSale.class);
            List<ItemSale> itemSales= typedQuery.getResultList();
           return itemSales.stream().filter(i-> i.getProduct().getIdProduct() == productId).collect(Collectors.toList());
        }
        catch (Exception ex){
            throw new EJBException(ex);
        }
    }
}
