package com.project.emazon.emazon.infrastructure.mappers;

import com.project.emazon.emazon.application.dtos.CategoryDTO;
import com.project.emazon.emazon.domain.model.Category;
import com.project.emazon.emazon.infrastructure.entities.CategoryEntity;

public class CategoryMapper {

    public static CategoryDTO ToCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId_category(category.getId_Category());
        categoryDTO.setName(category.getName());
        categoryDTO.setDescription(category.getDescription());
        return categoryDTO;};

    public static Category toCategory(CategoryDTO  categoryDTO) {
        Category category = new Category();
        category.setId_Category(categoryDTO.getId_category());
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        return category;
    };
    public static Category  toCategory(CategoryEntity CategoryEntity ) {
        Category category = new Category();
        category.setId_Category(CategoryEntity.getId_Category());
        category.setName(CategoryEntity.getName());
        category.setDescription(CategoryEntity.getDescription());
        return category;
    }

    public static CategoryEntity  toCategoryEntity(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId_Category(category.getId_Category());
        categoryEntity.setName(category.getName());
        categoryEntity.setDescription(category.getDescription());
        return categoryEntity;
    }
}
