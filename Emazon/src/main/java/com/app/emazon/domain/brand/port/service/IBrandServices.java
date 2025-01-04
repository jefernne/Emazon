package com.app.emazon.domain.brand.port.service;

import com.app.emazon.domain.brand.model.Brand;
import com.app.emazon.domain.brand.model.PaginateResultBrand;

public interface IBrandServices {
    void Save(Brand brand);
    PaginateResultBrand<Brand> findAllSortedAndPaginated(int page, int pageSize, String sortField, boolean ascending);
}
