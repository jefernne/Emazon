package com.project.emazon.emazon.infrastructure.controllers;
import com.project.emazon.emazon.application.dtos.CategoryDTO;
import com.project.emazon.emazon.application.services.CategoryService;
import com.project.emazon.emazon.domain.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CategoryControllerTest {
    private CategoryController categoryController;

    @Mock
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        categoryController = new CategoryController(categoryService);
    }

    @Test
    void testCreateCategory() {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName("Books");
        categoryDTO.setDescription("Category for books");

        Category category = new Category();
        category.setName("Books");
        category.setDescription("Category for books");
        when(categoryService.createCategory(any(Category.class))).thenReturn(category);

        ResponseEntity<CategoryDTO> response = categoryController.createCategory(categoryDTO);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals("Books", response.getBody().getName());
        verify(categoryService, times(1)).createCategory(any(Category.class));
    }
}
