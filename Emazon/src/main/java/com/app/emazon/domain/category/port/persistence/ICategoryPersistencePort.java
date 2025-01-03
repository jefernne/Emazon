package com.app.emazon.domain.category.port.persistence;

import com.app.emazon.domain.category.model.Category;
import com.app.emazon.domain.category.model.PaginatedResult;

import java.util.Optional;

public interface ICategoryPersistencePort {
    void save(Category category);
    Optional<Category> findByName(String name);
    PaginatedResult<Category>findAllSortedAndPaginated(int page, int pageSize, String sortField, boolean ascending);

}
