package com.app.emazon.domain.brand.port.persistence;

import com.app.emazon.domain.brand.model.Brand;
import com.app.emazon.domain.brand.model.PaginateResultBrand;
import com.app.emazon.domain.category.model.Category;
import com.app.emazon.domain.category.model.PaginatedResult;

import java.util.Optional;

public interface IBrandPersistence {
    void save(Brand brand);
    Optional<Brand> findByName(String name);
    PaginateResultBrand<Brand>findAllSortedAndPaginated(int page, int pageSize, String sortField, boolean ascending);
}
