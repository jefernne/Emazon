package com.app.emazon.application.brand.handler;

import com.app.emazon.application.brand.dto.BrandDto;
import com.app.emazon.application.category.dto.CategoryDto;
import com.app.emazon.domain.brand.model.Brand;
import com.app.emazon.domain.brand.model.PaginateResultBrand;

public interface IBrandHandler {
    void save (BrandDto brandDto);
    PaginateResultBrand<BrandDto>getAllBrands(int page, int pageSize, String sortBy, boolean ascending);
}
