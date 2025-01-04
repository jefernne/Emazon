package com.app.emazon.infrastructure.brand.rest;

import com.app.emazon.application.brand.dto.BrandDto;
import com.app.emazon.application.brand.handler.IBrandHandler;
import com.app.emazon.application.category.dto.CategoryDto;
import com.app.emazon.domain.brand.model.PaginateResultBrand;
import com.app.emazon.domain.category.model.PaginatedResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("brand")
public class BrandController {

    private final IBrandHandler brandHandler;


    public BrandController(IBrandHandler brandHandler) {
        this.brandHandler = brandHandler;
    }


    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody BrandDto brandDto) {
        System.out.println(brandDto.getBrandName());
        brandHandler.save(brandDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }


    @GetMapping
    public PaginateResultBrand<BrandDto> getBrands(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy,
            @RequestParam boolean ascending) {


        return brandHandler.getAllBrands(page, size, sortBy, ascending);

    }
}
