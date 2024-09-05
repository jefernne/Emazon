package com.project.emazon.emazon.application.services;

import com.project.emazon.emazon.domain.model.Category;
import com.project.emazon.emazon.domain.port.service.CategoryServicesUseCase;
import com.project.emazon.emazon.domain.usecase.CreateCategoryUseCase;

import java.util.List;

public class CategoryService implements CategoryServicesUseCase{
    private final CreateCategoryUseCase createCategoryUseCase;


    public CategoryService(CreateCategoryUseCase createCategoryUseCase) {
        this.createCategoryUseCase = createCategoryUseCase;
    }
    @Override
    public Category createCategory(Category category) {
        return createCategoryUseCase.createCategory(category);
    }

    @Override
    public List<Category> getCategories(int page, int size, String sortBy, boolean ascending) {
        return createCategoryUseCase.getCategories(page, size, sortBy, ascending);
    }
}
