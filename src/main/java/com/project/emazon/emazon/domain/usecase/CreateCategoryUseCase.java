package com.project.emazon.emazon.domain.usecase;

import com.project.emazon.emazon.domain.exception.ErrorMessages;
import com.project.emazon.emazon.domain.exception.InvalidCategoryException;
import com.project.emazon.emazon.domain.exception.ValidationError;
import com.project.emazon.emazon.domain.model.Category;
import com.project.emazon.emazon.domain.port.persistence.CategoryRepositoryPort;
import com.project.emazon.emazon.domain.port.service.CategoryServicesUseCase;


import java.util.ArrayList;
import java.util.List;

public class CreateCategoryUseCase  implements CategoryServicesUseCase {

    private final CategoryRepositoryPort categoryRepository;

    public CreateCategoryUseCase(CategoryRepositoryPort categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Category createCategory(Category category) {
        List<ValidationError> errors=   validateCategory(category);
        if(!errors.isEmpty()){
            throw new InvalidCategoryException("Validation failed",errors);
        }
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategories(int page, int size, String sortBy, boolean ascending) {
        return categoryRepository.findAllSortedAndPaginated(page, size, sortBy, ascending);
    }


    public List<ValidationError> validateCategory(Category category) {
     List<ValidationError> errors= new ArrayList<>();
     if(category.getName() == null || category.getName().isEmpty()) {
       errors.add(new ValidationError("name", ErrorMessages.CATEGORY_NAME_EMPTY));
     } else if (category.getName().length()>50) {
         errors.add(new ValidationError("name", ErrorMessages.CATEGORY_NAME_TOO_LONG));
     }
     categoryRepository.findByNombre(category.getName()).ifPresent(existingCategory ->
         errors.add(new ValidationError("name", ErrorMessages.CATEGORY_ALREADY_EXISTS))
     );

     if (category.getDescription() == null || category.getDescription().isEmpty()) {
         errors.add(new ValidationError("description", ErrorMessages.CATEGORY_DESCRIPTION_EMPTY));
     } else if (category.getDescription().length()>90) {
         errors.add(new ValidationError("description", ErrorMessages.CATEGORY_DESCRIPTION_TOO_LONG));

     }
        return errors;
    }
}
