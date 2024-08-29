package com.project.emazon.emazon.domain.port.service;

import com.project.emazon.emazon.domain.model.Category;

import java.util.List;

public interface CategoryServicesUseCase {
    Category createCategory(Category category);
    List<Category>getCategories(int page, int size, String sortBy, boolean ascending);
}
