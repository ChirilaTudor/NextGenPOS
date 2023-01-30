package com.nextgenpos.nextgenpos.common;

public class CategoryDto {

    private Long idCategory;

    private String categoryName;

    public CategoryDto(Long idCategory, String categoryName) {
        this.idCategory = idCategory;
        this.categoryName = categoryName;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
