package com.app.emazon.domain.category.port.service;

import com.app.emazon.domain.category.model.Category;
import com.app.emazon.domain.category.model.PaginatedResult;

public interface IcategoryServicePort {
    void Save(Category category);
    PaginatedResult<Category>getAllCategory(int page, int size, String sortBy,boolean ascending);
}
