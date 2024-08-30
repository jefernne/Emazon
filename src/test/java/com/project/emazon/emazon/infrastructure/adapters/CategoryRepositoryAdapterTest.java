package com.project.emazon.emazon.infrastructure.adapters;
import com.project.emazon.emazon.domain.model.Category;
import com.project.emazon.emazon.infrastructure.entities.CategoryEntity;
import com.project.emazon.emazon.infrastructure.repositories.JpaCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


public class CategoryRepositoryAdapterTest {
    private CategoryRepositoryAdapter adapter;

    @Mock
    private JpaCategoryRepository jpaCategoryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        adapter = new CategoryRepositoryAdapter(jpaCategoryRepository);
    }

    @Test
    void testSave() {
        Category category = new Category();
        category.setName("Books");
        category.setDescription("Category for books");
        CategoryEntity entity = new CategoryEntity();
        entity.setName("Books");
        entity.setDescription("Category for books");

        when(jpaCategoryRepository.save(any(CategoryEntity.class))).thenReturn(entity);

        Category result = adapter.save(category);

        assertEquals("Books", result.getName());
        verify(jpaCategoryRepository, times(1)).save(any(CategoryEntity.class));
    }

    @Test
    void testFindAllSortedAndPaginated() {
        CategoryEntity categoryEntity1 = new CategoryEntity();
        CategoryEntity categoryEntity2 = new CategoryEntity();
        categoryEntity1.setName("Electronics");
        categoryEntity1.setDescription("Description 1");
        categoryEntity2.setName("Books");
        categoryEntity2.setDescription("Description 2");
        List<CategoryEntity> categoryEntities = Arrays.asList(categoryEntity1, categoryEntity2);

        Page<CategoryEntity> page = new PageImpl<>(categoryEntities);
        when(jpaCategoryRepository.findAll(any(PageRequest.class))).thenReturn(page);

        List<Category> result = adapter.findAllSortedAndPaginated(0, 2, "name", true);

        assertEquals(2, result.size());
        assertEquals("Electronics", result.get(0).getName());

    }



}
