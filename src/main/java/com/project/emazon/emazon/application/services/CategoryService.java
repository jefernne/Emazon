package com.project.emazon.emazon.application.services;

import com.project.emazon.emazon.domain.model.Category;
import com.project.emazon.emazon.domain.port.service.CategoryServicesUseCase;
import com.project.emazon.emazon.domain.usecase.CreateCategoryUseCase;

public class CategoryService implements CategoryServicesUseCase{
    private final CreateCategoryUseCase createCategoryUseCase;

    public CategoryService(CreateCategoryUseCase createCategoryUseCase) {
        this.createCategoryUseCase = createCategoryUseCase;
    }
    @Override
    public Category createCategory(Category category) {
        return createCategoryUseCase.createCategory(category);
    }
}
