package com.project.emazon.emazon.infrastructure.adapters;
import com.project.emazon.emazon.domain.model.Category;
import com.project.emazon.emazon.infrastructure.entities.CategoryEntity;
import com.project.emazon.emazon.infrastructure.repositories.JpaCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



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


}
