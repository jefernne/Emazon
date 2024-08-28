package com.project.emazon.emazon.domain.port.persistence;

import com.project.emazon.emazon.domain.model.Category;

import java.util.Optional;

public interface CategoryRepositoryPort {
    Category save(Category category);
    Optional<Category> findByNombre(String name);

}
