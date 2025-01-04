package com.app.emazon.domain.category.usecase;

import com.app.emazon.domain.category.error.ErrorMessajeCategory;
import com.app.emazon.domain.category.error.InvalidCategoryExection;
import com.app.emazon.domain.category.error.MessageErrorCategory;
import com.app.emazon.domain.category.model.Category;
import com.app.emazon.domain.category.model.PaginatedResult;
import com.app.emazon.domain.category.port.persistence.ICategoryPersistencePort;
import com.app.emazon.domain.category.port.service.IcategoryServicePort;

import java.util.ArrayList;
import java.util.List;

public class CategoryUseCase implements IcategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }


    @Override
    public void Save(Category category) {
        List<MessageErrorCategory> errors = ValidateCategory(category);
        if(!errors.isEmpty()) {
          throw new InvalidCategoryExection("Validation failed",errors);
        }
        categoryPersistencePort.save(category);
    }



    private List<MessageErrorCategory> ValidateCategory (Category category) {
        List<MessageErrorCategory> errors = new ArrayList<>();

        if(category.getNombreCateogry() == null || category.getNombreCateogry().isEmpty()) {
            errors.add(new MessageErrorCategory("empty fields", ErrorMessajeCategory.CATEGORY_NAME_EMPTY));
        }else if(category.getNombreCateogry().length() >50) {
            errors.add(new MessageErrorCategory("name", ErrorMessajeCategory.CATEGORY_NAME_TOO_LONG));
        }
        categoryPersistencePort.findByName(category.getNombreCateogry())
                .ifPresent(existingCategory ->
                        errors.add(new MessageErrorCategory("category", ErrorMessajeCategory.CATEGORY_ALREADY_EXISTS)));

        if(category.getDescripcionCateogry() == null || category.getDescripcionCateogry().isEmpty()) {
            errors.add(new MessageErrorCategory("empty fields", ErrorMessajeCategory.CATEGORY_DESCRIPTION_EMPTY));
        }else if(category.getDescripcionCateogry().length() >90) {
            errors.add(new MessageErrorCategory("Description", ErrorMessajeCategory.CATEGORY_DESCRIPTION_TOO_LONG));
        }

        return errors;
    }



    @Override
    public PaginatedResult<Category> getAllCategory(int page, int size, String sortBy, boolean ascending) {
        return categoryPersistencePort.findAllSortedAndPaginated(page,size,sortBy,ascending);
    }



}
