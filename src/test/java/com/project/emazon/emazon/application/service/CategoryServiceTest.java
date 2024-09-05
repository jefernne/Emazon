package com.project.emazon.emazon.application.service;
import com.project.emazon.emazon.application.services.CategoryService;
import com.project.emazon.emazon.domain.model.Category;
import com.project.emazon.emazon.domain.usecase.CreateCategoryUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CategoryServiceTest {
    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CreateCategoryUseCase createCategoryUseCase;






    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateCategorySuccess() {
        Category category = new Category();
        category.setName("Books");
        category.setDescription("Category for books");

        when(createCategoryUseCase.createCategory(any(Category.class))).thenReturn(category);

        categoryService.createCategory(category);

        verify(createCategoryUseCase, times(1)).createCategory(category);
    }

    @Test
    void testFindAllSortedAndPaginated() {
        Category category1 = new Category();
        Category category2 = new Category();
        category1.setName("Electronics");
        category1.setDescription("Category for books");
        category2.setName("Books");
        category2.setDescription("Category for books");

        when(createCategoryUseCase.getCategories(0, 2, "name", true))
                .thenReturn(Arrays.asList(category1, category2));

        // Llamamos al método del servicio
        List<Category> result = categoryService.getCategories(0, 2, "name", true);

        System.out.println(result.get(0).getName());
        // Verificamos el resultado

        assertEquals(2, result.size());
        assertEquals("Electronics", result.get(0).getName());
    }
}
