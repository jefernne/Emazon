package com.app.emazon.infrastructure.brand.adapter.mapper;

import com.app.emazon.domain.brand.model.Brand;
import com.app.emazon.infrastructure.brand.entity.BrandEntity;

public class ImpBrandMapper implements  IBrandMapper {

    @Override
    public BrandEntity brandToBrandEntity(Brand brand) {
        BrandEntity brandEntity = new BrandEntity(brand.getIdBrand(),brand.getBrandName(),brand.getBrandDescription());
        return brandEntity;
    }

    @Override
    public Brand brandEntityToBrand(BrandEntity brandEntity) {
        Brand brand  = new Brand(brandEntity.getIdBrand(),brandEntity.getBrandName(),brandEntity.getBrandDescription());
        return brand;
    }
}
