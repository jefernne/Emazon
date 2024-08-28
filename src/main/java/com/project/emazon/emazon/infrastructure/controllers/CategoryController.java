package com.project.emazon.emazon.infrastructure.controllers;

import com.project.emazon.emazon.application.dtos.CategoryDTO;
import com.project.emazon.emazon.application.services.CategoryService;
import com.project.emazon.emazon.infrastructure.mappers.CategoryMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        return new ResponseEntity<>(CategoryMapper.toCategoryDTO(categoryService.createCategory(CategoryMapper.toCategory(categoryDTO))), HttpStatus.CREATED);
    }

}
