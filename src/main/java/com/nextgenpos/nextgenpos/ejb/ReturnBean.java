package com.nextgenpos.nextgenpos.ejb;

import com.nextgenpos.nextgenpos.entities.ItemReturn;
import com.nextgenpos.nextgenpos.entities.ItemSale;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Date;
import java.util.logging.Logger;

@Stateless
public class ReturnBean {

    private static final Logger LOG = Logger.getLogger(ProductsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public void returnProducts(long itemSaleId, Integer quantity) {
        LOG.info("returnProducts");

        try {
            ItemSale itemSale = entityManager.find(ItemSale.class, itemSaleId);
            ItemReturn itemReturn = new ItemReturn();
            itemReturn.setItemSale(itemSale);
            itemReturn.setQuantity(quantity);
            Date currentDate = new Date();
            itemReturn.setReturnDate(currentDate);

            entityManager.persist(itemReturn);
            itemSale.setItemReturn(itemReturn);

        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
}
