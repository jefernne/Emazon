package com.project.emazon.emazon.infrastructure.configs;

import com.project.emazon.emazon.application.services.CategoryService;
import com.project.emazon.emazon.domain.port.persistence.CategoryRepositoryPort;
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
}
