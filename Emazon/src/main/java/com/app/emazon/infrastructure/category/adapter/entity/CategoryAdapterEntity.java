package com.app.emazon.infrastructure.category.adapter.entity;


import com.app.emazon.domain.category.model.Category;
import com.app.emazon.domain.category.model.PaginatedResult;
import com.app.emazon.domain.category.port.persistence.ICategoryPersistencePort;
import com.app.emazon.infrastructure.category.adapter.mapper.CategoryMapper;
import com.app.emazon.infrastructure.category.adapter.mapper.ICategoryMapper;
import com.app.emazon.infrastructure.category.adapter.repository.ICategoryRepository;
import com.app.emazon.infrastructure.category.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryAdapterEntity implements ICategoryPersistencePort {
    private final ICategoryRepository repository;
    private final ICategoryMapper mapper;

    public CategoryAdapterEntity(ICategoryRepository repository, ICategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void save(Category category){
            repository.save(mapper.categoryToCategoryEntity(category));
    }

    @Override
    public Optional<Category> findByName(String nombreCateogry) {
        return repository.findBynombreCateogry(nombreCateogry).map(categoryEntity -> mapper.categoryEntityToCategory(categoryEntity));
    }

    @Override
    public PaginatedResult<Category> findAllSortedAndPaginated(int page, int pageSize, String sortBy, boolean ascending) {
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        PageRequest pageRequest = PageRequest.of(page, pageSize, sort);
        Page<CategoryEntity> articles = repository.findAll(pageRequest);
        List<Category> categories = articles.stream().map(mapper::categoryEntityToCategory).collect(Collectors.toList());
        return new PaginatedResult<>(categories,
                articles.getSize(),
                articles.getNumber(),
                articles.getTotalElements(),
                articles.isFirst(),
                articles.isLast(),
                articles.getTotalPages());
    }



}
