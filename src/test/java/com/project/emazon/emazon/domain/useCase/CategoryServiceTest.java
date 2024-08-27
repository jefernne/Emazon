package com.project.emazon.emazon.domain.useCase;

import com.project.emazon.emazon.application.services.CategoryService;
import com.project.emazon.emazon.domain.exception.InvalidCategoryException;
import com.project.emazon.emazon.domain.model.Category;
import com.project.emazon.emazon.domain.port.persistence.CategoryRepositoryPort;
import com.project.emazon.emazon.domain.usecase.CreateCategoryUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CategoryServiceTest {
    private CreateCategoryUseCase createCategoryUseCase;

    @Mock
    private CategoryRepositoryPort categoryRepositoryPort;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        createCategoryUseCase = new CreateCategoryUseCase(categoryRepositoryPort);
    }

    @Test
    void testCreateCategorySuccess() {
        Category category = new Category();
        category.setName("Books");
        category.setDescription("Category for books");

        when(categoryRepositoryPort.save(category)).thenReturn(category);

        Category result = createCategoryUseCase.createCategory(category);

        assertNotNull(result);
        assertEquals("Books", result.getName());
        verify(categoryRepositoryPort, times(1)).save(category);
    }
    @Test
    void testCreateCategoryInvalidName() {
        Category category = new Category();
        category.setName(""); // Nombre inválido
        category.setDescription("Category without name");

        assertThrows(InvalidCategoryException.class, () -> {
            createCategoryUseCase.createCategory(category);
        });

        verify(categoryRepositoryPort, never()).save(any(Category.class));
    }
    @Test
    void testCreateCategoryDuplicateName() {
        Category category = new Category();
        category.setName("Books");
        category.setDescription("Category for books");

        when(categoryRepositoryPort.findByNombre(category.getName())).thenReturn(Optional.of(category));

        assertThrows(InvalidCategoryException.class, () -> {
            createCategoryUseCase.createCategory(category);
        });

        verify(categoryRepositoryPort, never()).save(any(Category.class));
    }
}


