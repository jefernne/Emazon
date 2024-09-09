package com.project.emazon.emazon.application.service;

import com.project.emazon.emazon.application.services.BrandService;
import com.project.emazon.emazon.domain.model.Brand;

import com.project.emazon.emazon.domain.usecase.CreateBrandUseCase;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class BrandServiceTest {
@InjectMocks
    private BrandService brandService;

@Mock
    private CreateBrandUseCase createBrandUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testCreateCategorySuccess() {
        Brand brand  = new Brand();
        brand.setName("Books");
        brand.setDescription("Books for books");
        when(createBrandUseCase.createBrand(any(Brand.class))).thenReturn(brand);
        createBrandUseCase.createBrand(brand);

        verify(createBrandUseCase, times(1)).createBrand(brand);

    }
}
