package com.project.emazon.emazon.domain.useCase;
import com.project.emazon.emazon.domain.exception.InvalidCategoryException;
import com.project.emazon.emazon.domain.model.Brand;

import com.project.emazon.emazon.domain.port.persistence.BrandRepositoryPort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import com.project.emazon.emazon.domain.usecase.CreateBrandUseCase;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BrandServiceTest {

    private CreateBrandUseCase createBrandUseCase;

    @Mock
    private BrandRepositoryPort brandRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        createBrandUseCase  = new CreateBrandUseCase(brandRepository);
    }

    @Test
    void testCreateCategorySuccess() {
        Brand brand = new Brand();
        brand.setName("samsung");
        brand.setDescription("technology");

        when(brandRepository.save(brand)).thenReturn(brand);

        Brand result = createBrandUseCase.createBrand(brand);

        assertNotNull(result);
        assertEquals("samsung", result.getName());
        assertEquals("technology", result.getDescription());
        verify(brandRepository, times(1)).save(brand);

    }
    @Test
    void testCreateBrandInvaidName(){
        Brand brand = new Brand();
        brand.setName("");
        brand.setDescription("technology");

        assertThrows(InvalidCategoryException.class, () -> createBrandUseCase.createBrand(brand));

        verify(brandRepository, never()).save(any(Brand.class));

    }
    @Test
    void testCreateBrandInvaidDescription(){
        Brand brand = new Brand();
        brand.setName("samsung");
        brand.setDescription("");
        assertThrows(InvalidCategoryException.class, () -> createBrandUseCase.createBrand(brand));
        verify(brandRepository, never()).save(any(Brand.class));

    }


    @Test
    void testCreateDuplicateName(){
        Brand brand = new Brand();
        brand.setName("samsung");
        brand.setDescription("technology");

        when(brandRepository.findByNombre(brand.getName())).thenReturn(Optional.of(brand));

        assertThrows(InvalidCategoryException.class, () -> createBrandUseCase.createBrand(brand));
        verify(brandRepository, never()).save(any(Brand.class));
    }
}
