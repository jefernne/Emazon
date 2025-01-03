package com.app.emazon.infrastructure.brand.rest;

import com.app.emazon.application.brand.dto.BrandDto;
import com.app.emazon.application.brand.handler.IBrandHandler;
import com.app.emazon.application.category.dto.CategoryDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
