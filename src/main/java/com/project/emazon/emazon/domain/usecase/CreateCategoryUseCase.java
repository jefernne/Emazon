package com.project.emazon.emazon.domain.usecase;

import com.project.emazon.emazon.domain.exception.InvalidCategoryException;
import com.project.emazon.emazon.domain.exception.ValidationError;
import com.project.emazon.emazon.domain.model.Category;
import com.project.emazon.emazon.domain.port.persistence.CategoryRepositoryPort;
import com.project.emazon.emazon.domain.port.service.CategoryServicesUseCase;
import com.project.emazon.emazon.infrastructure.errors.FieldError;

import java.util.ArrayList;
import java.util.List;

public class CreateCategoryUseCase  implements CategoryServicesUseCase {

    private final CategoryRepositoryPort categoryRepository;
    public CreateCategoryUseCase(CategoryRepositoryPort categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Category createCategory(Category category) {
        List<ValidationError> errors=   ValidateCategory(category);
        if(!errors.isEmpty()){
            throw new InvalidCategoryException("Validation failed",errors);
        }
        return categoryRepository.save(category);
    }


    public List<ValidationError> ValidateCategory(Category category) {
     List<ValidationError> errors= new ArrayList<ValidationError>();
     if(category.getName() == null || category.getName().isEmpty()) {
       errors.add(new ValidationError("name", "The category name cannot be empty."));
     } else if (category.getName().length()>50) {
         errors.add(new ValidationError("name", "The category name cannot be longer than 50 characters."));
     }
     categoryRepository.findByNombre(category.getName()).ifPresent(existingCategory ->{
         errors.add(new ValidationError("name", "The category already exists."));
     } );

     if (category.getDescription() == null || category.getDescription().isEmpty()) {
         errors.add(new ValidationError("description", "The category description cannot be empty."));
     } else if (category.getDescription().length()>90) {
         errors.add(new ValidationError("description", "The category description cannot be longer than 90 characters."));

     }
        return errors;
    }
}
