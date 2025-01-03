package com.app.emazon.application.category.mapper;


import com.app.emazon.application.category.dto.CategoryDto;
import com.app.emazon.domain.category.model.Category;

public class MappetCategory implements  ImpMapperCategory{


    @Override
    public Category categoryToCategoryDto(CategoryDto categoryDto) {
        if(categoryDto == null){
            return null;
        }
        Category category = new Category(categoryDto.getIdCateogry(), categoryDto.getNombreCateogry(), categoryDto.getDescripcionCateogry());
        return category;
    }

    @Override
    public CategoryDto categoryDtoToCategory(Category category) {
        if(category == null){
            return null;
        }
        CategoryDto categoryDto = new CategoryDto(category.getIdCateogry(), category.getNombreCateogry(), category.getDescripcionCateogry());
        return categoryDto;
    }
}
