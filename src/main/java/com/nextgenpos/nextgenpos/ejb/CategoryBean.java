package com.nextgenpos.nextgenpos.ejb;

import com.nextgenpos.nextgenpos.common.CategoryDto;
import com.nextgenpos.nextgenpos.common.ProductDto;
import com.nextgenpos.nextgenpos.common.UserDto;
import com.nextgenpos.nextgenpos.entities.Category;
import com.nextgenpos.nextgenpos.entities.Product;
import com.nextgenpos.nextgenpos.entities.User;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Stateless
public class CategoryBean {

    private static final Logger LOG = Logger.getLogger(PasswordBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public void createCategory(String categoryName) {
        LOG.info("createCategory");

        Category category = new Category();
        category.setName(categoryName);

        entityManager.persist(category);
    }

    public List<CategoryDto> findAllCategories() {
        try {
            LOG.info("findAllCategories");
            TypedQuery<Category> typedQuery = entityManager.createQuery("SELECT c FROM Category c", Category.class);
            List<Category> categories = typedQuery.getResultList();
            return copyCategoriesToDto(categories);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<CategoryDto> copyCategoriesToDto(List<Category> categories) {
        List<CategoryDto> categoryDtos;
        categoryDtos = categories
                .stream()
                .map(x -> new CategoryDto(x.getIdCategory(), x.getName())).collect(Collectors.toList());
        return categoryDtos;
    }

    public CategoryDto findById(Long categoryId) {
        LOG.info("findCategoryById");

        try {
            Category category = entityManager.find(Category.class, categoryId);
            return new CategoryDto( category.getIdCategory(),
                                    category.getName());
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

}
