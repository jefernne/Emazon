package com.app.emazon.infrastructure.category.adapter.mapper;

import com.app.emazon.domain.category.model.Category;
import com.app.emazon.infrastructure.category.entity.CategoryEntity;

public interface ICategoryMapper {
 Category   categoryEntityToCategory(CategoryEntity categoryEntity);
 CategoryEntity categoryToCategoryEntity(Category category);

}
