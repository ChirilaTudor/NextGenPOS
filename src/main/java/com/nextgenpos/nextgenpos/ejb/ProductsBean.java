package com.nextgenpos.nextgenpos.ejb;

import com.nextgenpos.nextgenpos.common.ProductDto;
import com.nextgenpos.nextgenpos.entities.Product;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Stateless
public class ProductsBean {

    private static final Logger LOG = Logger.getLogger(ProductsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;


    public List<ProductDto> findAllProducts() {
        try {
            LOG.info("findAllProducts");
            TypedQuery<Product> typedQuery = entityManager.createQuery("SELECT p FROM Product p", Product.class);
            List<Product> products = typedQuery.getResultList();
            return copyProductsToDto(products);
        } catch (Exception ex){
            throw new EJBException(ex);
        }
    }

    private List<ProductDto> copyProductsToDto(List<Product> products) {
        LOG.info("copyProductsToDto");

        List<ProductDto> productDto;
        productDto = products
                .stream()
                .map(x -> new ProductDto(x.getIdProduct(), x.getProductName(), x.getQuantity(), x.getPrice(), x.getDescription(), x.getProvider())).collect(Collectors.toList());
        return productDto;
    }

    public void createProduct(String productName, Integer quantity, Float price, String description, String provider) {
        LOG.info("createProduct");

        Product product = new Product();
        product.setProductName(productName);
        product.setQuantity(quantity);
        product.setPrice(price);
        product.setDescription(description);
        product.setProvider(provider);

        entityManager.persist(product);
    }

    public void updateProduct(String productId, String productName, Integer quantity, Float price, String description, String provider) {
        LOG.info("updateProduct");

        Product product = entityManager.find(Product.class, productId);
        product.setProductName(productName);
        product.setQuantity(quantity);
        product.setPrice(price);
        product.setDescription(description);
        product.setProvider(provider);

    }

    public ProductDto findById(Long productId) {
        LOG.info("findProductsById");

        try {
            Product product = entityManager.find(Product.class, productId);
            return new ProductDto(product.getIdProduct(),
                    product.getProductName(),
                    product.getQuantity(),
                    product.getPrice(),
                    product.getDescription(),
                    product.getProvider());
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public void deleteProductsByIds(List<Long> productsIds) {
        LOG.info("deleteProductsByIds");

        for(Long productId : productsIds){
            Product product = entityManager.find(Product.class, productId);
            entityManager.remove(product);
        }
    }
}
