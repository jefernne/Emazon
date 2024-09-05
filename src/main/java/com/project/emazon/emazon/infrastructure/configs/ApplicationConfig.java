package com.project.emazon.emazon.infrastructure.configs;

import com.project.emazon.emazon.application.services.BrandService;
import com.project.emazon.emazon.application.services.CategoryService;
import com.project.emazon.emazon.domain.port.persistence.BrandRepositoryPort;
import com.project.emazon.emazon.domain.port.persistence.CategoryRepositoryPort;
import com.project.emazon.emazon.domain.usecase.CreateBrandUseCase;
import com.project.emazon.emazon.domain.usecase.CreateCategoryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {


    @Bean
    public CategoryService categoryService(CategoryRepositoryPort categoryRepositoryPort) {
        return new CategoryService(
                new CreateCategoryUseCase(categoryRepositoryPort)
        );
    }
    @Bean
    public BrandService brandService(BrandRepositoryPort brandRepositoryPort) {
        return new BrandService(
                new CreateBrandUseCase(brandRepositoryPort)
        );
    }



}
