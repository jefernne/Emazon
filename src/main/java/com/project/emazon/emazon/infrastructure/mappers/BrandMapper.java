package com.project.emazon.emazon.infrastructure.mappers;

import com.project.emazon.emazon.application.dtos.BrandDTO;
import com.project.emazon.emazon.domain.model.Brand;
import com.project.emazon.emazon.infrastructure.entities.BrandEntity;

public class BrandMapper {
    public static BrandDTO toBrandDTO(Brand brand) {
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setIdBrand(brand.getIdBrand());
        brandDTO.setName(brand.getName());
        brandDTO.setDescription(brand.getDescription());
        return brandDTO;
    }
    public static Brand toBrand(BrandDTO brandDTO) {
        Brand brand = new Brand();
        brand.setIdBrand(brandDTO.getIdBrand());
        brand.setName(brandDTO.getName());
        brand.setDescription(brandDTO.getDescription());
        return brand;
    }

    public static BrandEntity toBradEntity(Brand brand) {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setIdBrand(brand.getIdBrand());
        brandEntity.setName(brand.getName());
        brandEntity.setDescription(brand.getDescription());
        return brandEntity;
    }

   public static Brand toBrand(BrandEntity brandEntity) {
        Brand brand = new Brand();
        brand.setIdBrand(brandEntity.getIdBrand());
        brand.setName(brandEntity.getName());
        brand.setDescription(brandEntity.getDescription());
        return brand;
   }

}
