package com.app.emazon.application.category.handler;

import com.app.emazon.application.category.dto.CategoryDto;
import com.app.emazon.domain.category.model.Category;
import com.app.emazon.domain.category.model.PaginatedResult;

public interface IcategoryHadler {
    void save (CategoryDto categoryDto);
    PaginatedResult<CategoryDto>  getAllCategory (int page, int pageSize, String sortBy, boolean ascending);
}
