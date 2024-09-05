package com.project.emazon.emazon.infrastructure.mappers;

import com.project.emazon.emazon.application.dtos.CategoryDTO;
import com.project.emazon.emazon.domain.model.Category;
import com.project.emazon.emazon.infrastructure.entities.CategoryEntity;

public class CategoryMapper {

    public static CategoryDTO toCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setIdcategory(category.getIdCategory());
        categoryDTO.setName(category.getName());
        categoryDTO.setDescription(category.getDescription());
        return categoryDTO;
    }

    public static Category toCategory(CategoryDTO  categoryDTO) {
        Category category = new Category();
        category.setIdCategory(categoryDTO.getIdcategory());
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        return category;
    }
    public static Category  toCategory(CategoryEntity categoryEntity ) {
        Category category = new Category();
        category.setIdCategory(categoryEntity.getIdCategory());
        category.setName(categoryEntity.getName());
        category.setDescription(categoryEntity.getDescription());
        return category;
    }

    public static CategoryEntity  toCategoryEntity(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setIdCategory(category.getIdCategory());
        categoryEntity.setName(category.getName());
        categoryEntity.setDescription(category.getDescription());
        return categoryEntity;
    }



}
