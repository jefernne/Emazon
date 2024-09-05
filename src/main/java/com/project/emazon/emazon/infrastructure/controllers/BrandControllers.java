package com.project.emazon.emazon.infrastructure.controllers;

import com.project.emazon.emazon.application.dtos.BrandDTO;

import com.project.emazon.emazon.application.services.BrandService;

import com.project.emazon.emazon.infrastructure.mappers.BrandMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand")
public class BrandControllers {
    private final BrandService brandService;

    public BrandControllers(BrandService brandService) {
        this.brandService = brandService;
    }
    @PostMapping
    public ResponseEntity<BrandDTO> createCategory(@RequestBody BrandDTO brandDTO) {
        System.out.println("hola");
        return new ResponseEntity<>(BrandMapper.toBrandDTO(brandService.createBrand(BrandMapper.toBrand(brandDTO))), HttpStatus.CREATED);
    }
}