package com.app.emazon.application.category.mapper;

import com.app.emazon.application.category.dto.CategoryDto;
import com.app.emazon.domain.category.model.Category;

public interface ImpMapperCategory {
    Category categoryToCategoryDto(CategoryDto categoryDto);
    CategoryDto categoryDtoToCategory(Category category);
}
