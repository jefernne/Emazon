package com.project.emazon.emazon.infrastructure.adapters;

import com.project.emazon.emazon.domain.model.Category;
import com.project.emazon.emazon.domain.port.persistence.CategoryRepositoryPort;
import com.project.emazon.emazon.infrastructure.entities.CategoryEntity;
import com.project.emazon.emazon.infrastructure.mappers.CategoryMapper;
import com.project.emazon.emazon.infrastructure.repositories.JpaCategoryRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class CategoryRepositoryAdapter implements CategoryRepositoryPort {
    private final JpaCategoryRepository jpaCategoryRepository;


    public CategoryRepositoryAdapter(JpaCategoryRepository jpaCategoryRepository) {
        this.jpaCategoryRepository = jpaCategoryRepository;
    }

    @Override
    public Category save(Category category) {
        CategoryEntity saveCategoryEntity = jpaCategoryRepository.save(CategoryMapper.toCategoryEntity(category));
        return CategoryMapper.toCategory(saveCategoryEntity);
    }

    @Override
    public Optional<Category> findByNombre(String name) {
        return jpaCategoryRepository.findByName(name).map(CategoryMapper::toCategory);
    }
}
