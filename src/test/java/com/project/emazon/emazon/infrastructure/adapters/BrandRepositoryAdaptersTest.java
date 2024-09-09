package com.project.emazon.emazon.infrastructure.adapters;


import com.project.emazon.emazon.domain.model.Brand;
import com.project.emazon.emazon.infrastructure.entities.BrandEntity;
import com.project.emazon.emazon.infrastructure.entities.CategoryEntity;
import com.project.emazon.emazon.infrastructure.repositories.JpaBrandRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
public class BrandRepositoryAdaptersTest {
     private BrandRepositoryAdapter adapter;

     @Mock
    private JpaBrandRepository jpaBrandRepository;

     @BeforeEach
    void setUp(){
         MockitoAnnotations.openMocks(this);
         adapter = new BrandRepositoryAdapter(jpaBrandRepository);
     }
     @Test
    void testSave(){
         Brand brand  = new Brand();
         brand.setName("Books");
         brand.setDescription("Books for books");
         BrandEntity brandEntity = new BrandEntity();
         brandEntity.setName("Books");
         brandEntity.setDescription("Books for books");

       when(jpaBrandRepository.save(any(BrandEntity.class))).thenReturn(brandEntity);
       Brand savedBrand = adapter.save(brand);
        assertNotNull("Books", savedBrand.getName());
        verify(jpaBrandRepository, times(1)).save(any(BrandEntity.class));
     }

}
