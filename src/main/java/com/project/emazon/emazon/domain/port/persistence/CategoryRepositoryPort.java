package com.project.emazon.emazon.domain.port.persistence;

import com.project.emazon.emazon.domain.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryPort {
    Category save(Category category);
    Optional<Category> findByNombre(String name);
    List<Category>findAllSortedAndPaginated(int page, int size, String sortBy, boolean ascending);

}
