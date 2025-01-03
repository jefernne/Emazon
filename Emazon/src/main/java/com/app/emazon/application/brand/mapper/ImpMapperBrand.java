package com.app.emazon.application.brand.mapper;

import com.app.emazon.application.brand.dto.BrandDto;
import com.app.emazon.domain.brand.model.Brand;

public class ImpMapperBrand implements IMapperBrand {
    @Override
    public Brand BrandDtoToBrand(BrandDto brandDto) {
        if(brandDto == null){
            return null;
        }
        Brand brand = new Brand(brandDto.getIdBrand(),brandDto.getBrandName(),brandDto.getBrandDescription());
        return brand;
    }

    @Override
    public BrandDto BrandToBrandDto(Brand brand) {

        if(brand == null){
            return null;
        }
        BrandDto brandDto = new BrandDto(brand.getIdBrand(),brand.getBrandName(), brand.getBrandDescription());
        return brandDto;
    }
}
