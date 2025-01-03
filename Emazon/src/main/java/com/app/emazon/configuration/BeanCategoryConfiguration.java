package com.app.emazon.configuration;

import com.app.emazon.application.category.handler.CategoryHandler;
import com.app.emazon.application.category.handler.IcategoryHadler;
import com.app.emazon.application.category.mapper.MappetCategory;
import com.app.emazon.domain.category.port.persistence.ICategoryPersistencePort;
import com.app.emazon.domain.category.usecase.CategoryUseCase;
import com.app.emazon.infrastructure.category.adapter.entity.CategoryAdapterEntity;
import com.app.emazon.infrastructure.category.adapter.mapper.CategoryMapper;

import com.app.emazon.infrastructure.category.adapter.repository.ICategoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanCategoryConfiguration {

    @Bean
    public CategoryAdapterEntity categoryAdapterEntity(ICategoryRepository categoryRepository) {
        return new CategoryAdapterEntity(categoryRepository,new CategoryMapper());
    }


    @Bean
    public IcategoryHadler IcategoryHadler(ICategoryPersistencePort categoryPersistencePort ) {
        return new CategoryHandler(new CategoryUseCase(categoryPersistencePort), new MappetCategory());

    }


}
