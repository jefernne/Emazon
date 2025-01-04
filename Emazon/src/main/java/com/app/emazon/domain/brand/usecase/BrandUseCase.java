package com.app.emazon.domain.brand.usecase;

import com.app.emazon.domain.brand.error.ErrorMessajeBrand;
import com.app.emazon.domain.brand.error.InvalidBrandeExection;
import com.app.emazon.domain.brand.error.MessageErrorBrand;
import com.app.emazon.domain.brand.model.Brand;
import com.app.emazon.domain.brand.model.PaginateResultBrand;
import com.app.emazon.domain.brand.port.persistence.IBrandPersistence;
import com.app.emazon.domain.brand.port.service.IBrandServices;

import java.util.ArrayList;
import java.util.List;

public class BrandUseCase implements IBrandServices {

    private final IBrandPersistence brandPersistence;

    public BrandUseCase(IBrandPersistence brandPersistence) {
        this.brandPersistence = brandPersistence;
    }

    @Override
    public void Save(Brand brand) {
        List<MessageErrorBrand>errors = ValidateBrand(brand);
        if(!errors.isEmpty()) {
            throw new InvalidBrandeExection("Validation failed", errors);
        }
        brandPersistence.save(brand);


    }

    @Override
    public PaginateResultBrand<Brand> findAllSortedAndPaginated(int page, int pageSize, String sortField, boolean ascending) {
        return brandPersistence.findAllSortedAndPaginated(page,pageSize,sortField,ascending);
    }


    List<MessageErrorBrand>ValidateBrand (Brand brand) {
        List<MessageErrorBrand> errors = new ArrayList<>();
        if(brand.getBrandName().isEmpty() || brand.getBrandName() == null) {
            errors.add(new MessageErrorBrand("Brand", ErrorMessajeBrand.BRAND_NAME_EMPTY));
        }
        else if(brand.getBrandName().length() >50) {
            errors.add(new MessageErrorBrand("name", ErrorMessajeBrand.BRAND_NAME_TOO_LONG));
        }
        brandPersistence.findByName(brand.getBrandName())
                .ifPresent(existingCategory ->
                        errors.add(new MessageErrorBrand("category", ErrorMessajeBrand.BRAND_ALREADY_EXISTS)));

        if(brand.getBrandDescription() == null || brand.getBrandDescription().isEmpty()) {
            errors.add(new MessageErrorBrand("Description", ErrorMessajeBrand.BRAND_DESCRIPTION_EMPTY));
        }else if(brand.getBrandDescription().length() >90) {
            errors.add(new MessageErrorBrand("Description",ErrorMessajeBrand.BRAND_DESCRIPTION_TOO_LONG));
        }

        return errors;
    }


}
