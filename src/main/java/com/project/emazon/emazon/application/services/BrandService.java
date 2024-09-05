package com.project.emazon.emazon.application.services;

import com.project.emazon.emazon.domain.model.Brand;
import com.project.emazon.emazon.domain.port.service.BrandServicesUseCase;
import com.project.emazon.emazon.domain.usecase.CreateBrandUseCase;

public class BrandService implements BrandServicesUseCase {
    private final CreateBrandUseCase createBrandUseCase;

    public BrandService(CreateBrandUseCase createBrandUseCase) {
        this.createBrandUseCase = createBrandUseCase;
    }

    @Override
    public Brand createBrand(Brand brand) {
        return createBrandUseCase.createBrand(brand);
    }


}
