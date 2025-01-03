package com.app.emazon.infrastructure.brand.adapter.mapper;


import com.app.emazon.domain.brand.model.Brand;
import com.app.emazon.infrastructure.brand.entity.BrandEntity;

public interface IBrandMapper {
  BrandEntity brandToBrandEntity (Brand brand);
  Brand brandEntityToBrand (BrandEntity brandEntity);
}
