package com.app.emazon.infrastructure.category.adapter.mapper;

import com.app.emazon.domain.category.model.Category;
import com.app.emazon.infrastructure.category.entity.CategoryEntity;
import org.hibernate.annotations.Comment;


public class CategoryMapper implements ICategoryMapper{
    @Override
    public Category categoryEntityToCategory(CategoryEntity categoryEntity) {
        Category category = new Category();
        category.setIdCateogry(categoryEntity.getIdCateogry());
        category.setNombreCateogry(categoryEntity.getNombreCateogry());
        category.setDescripcionCateogry(categoryEntity.getDescripcionCateogry());

        return category;
    }

    @Override
    public CategoryEntity categoryToCategoryEntity(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setIdCateogry(category.getIdCateogry());
        categoryEntity.setNombreCateogry(category.getNombreCateogry());
        categoryEntity.setDescripcionCateogry(category.getDescripcionCateogry());
        return categoryEntity;
    }
}
