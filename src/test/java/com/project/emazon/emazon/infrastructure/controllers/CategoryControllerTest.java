package com.project.emazon.emazon.infrastructure.controllers;
import com.project.emazon.emazon.application.dtos.CategoryDTO;
import com.project.emazon.emazon.application.services.CategoryService;
import com.project.emazon.emazon.domain.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;


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

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Books", response.getBody().getName());
        verify(categoryService, times(1)).createCategory(any(Category.class));
    }
    @Test
    void testGetAllCategories() {
        // Datos de prueba
        Category category1 = new Category();
        Category category2 = new Category();
        category1.setName("Electronics");
        category1.setDescription("Description 1");
        category2.setName("Books");
        category2.setDescription("Description 2");


        // Simulamos el comportamiento del servicio
        when(categoryService.getCategories(0, 3, "name", true))
                .thenReturn(Arrays.asList(category1, category2));

        // Llamamos al método del controlador
        ResponseEntity<List<CategoryDTO>> response = categoryController.getCategories(0,3,"name",true);

        // Verificamos el resultado
        System.out.println("First category name: " + response.getBody().get(0).getName());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        assertEquals("Electronics", response.getBody().get(0).getName());

    }
}
