package com.app.emazon.application.brand.mapper;

import com.app.emazon.application.brand.dto.BrandDto;
import com.app.emazon.domain.brand.model.Brand;

public interface IMapperBrand {
    Brand BrandDtoToBrand(BrandDto brandDto);
    BrandDto BrandToBrandDto(Brand brand);
}
