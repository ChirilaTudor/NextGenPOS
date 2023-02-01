package com.nextgenpos.nextgenpos.ejb;

import com.nextgenpos.nextgenpos.common.ProductDto;
import com.nextgenpos.nextgenpos.entities.Product;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.logging.Logger;

@Stateless
public class SearchBean {

    @Inject
    ProductsBean productsBean;

    @PersistenceContext
    EntityManager entityManager;

    private static final Logger LOG = Logger.getLogger(ProductsBean.class.getName());

    public List<ProductDto> searchProductsByName(String name) {
        LOG.info("searchProductsByName");

        try {
            List<Product> products = entityManager
                    .createQuery("SELECT p FROM Product p where p.productName LIKE CONCAT('%',:name ,'%')", Product.class)
                    .setParameter("name", name)
                    .getResultList();
            if (products.isEmpty()) {
                return null;
            }

            return productsBean.copyProductsToDto(products);

        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
}
