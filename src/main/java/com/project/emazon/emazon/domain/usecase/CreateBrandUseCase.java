package com.project.emazon.emazon.domain.usecase;

import com.project.emazon.emazon.domain.exception.ErrorMessages;
import com.project.emazon.emazon.domain.exception.InvalidCategoryException;
import com.project.emazon.emazon.domain.exception.ValidationError;
import com.project.emazon.emazon.domain.model.Brand;

import com.project.emazon.emazon.domain.port.persistence.BrandRepositoryPort;
import com.project.emazon.emazon.domain.port.service.BrandServicesUseCase;


import java.util.ArrayList;
import java.util.List;


public class CreateBrandUseCase implements BrandServicesUseCase {

   private final BrandRepositoryPort brandRepositoryPort;

   public CreateBrandUseCase(BrandRepositoryPort brandRepositoryPort) {
       this.brandRepositoryPort = brandRepositoryPort;
   }
    @Override
    public Brand createBrand(Brand brand) {
        List<ValidationError> errors = validateBrand(brand);
        if(!errors.isEmpty()) {
            throw new InvalidCategoryException("Validation failed", errors);
        }
        return brandRepositoryPort.save(brand);
    }

   public List<ValidationError> validateBrand(Brand brand) {
        List<ValidationError> error = new ArrayList<>();
        if(brand.getName() == null || brand.getName().isEmpty()) {
            error.add(new ValidationError("name Brand", ErrorMessages.BRAND_NAME_EMPTY));
        } else if (brand.getName().length() > 50) {
            error.add(new ValidationError("name Brand", ErrorMessages.BRAND_NAME_TOO_LONG));
            
        }
       brandRepositoryPort.findByNombre(brand.getName()).ifPresent(existingBrand ->
               error.add(new ValidationError("brand", ErrorMessages.BRAND_ALREADY_EXISTS))
               );

        if(brand.getDescription() == null || brand.getDescription().isEmpty()) {
            error.add(new ValidationError("description Brand", ErrorMessages.BRAND_DESCRIPTION_EMPTY));
        } else if (brand.getDescription().length() > 90) {
            error.add(new ValidationError("description Brand", ErrorMessages.BRAND_DESCRIPTION_TOO_LONG));
        }

       return error;
   }


}