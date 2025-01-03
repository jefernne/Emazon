package com.app.emazon.infrastructure.category.rest;

import com.app.emazon.application.category.dto.CategoryDto;
import com.app.emazon.application.category.handler.CategoryHandler;
import com.app.emazon.application.category.handler.IcategoryHadler;
import com.app.emazon.domain.category.model.PaginatedResult;
import jakarta.annotation.security.PermitAll;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final IcategoryHadler icategoryHadler;

    public CategoryController(IcategoryHadler icategoryHadler) {
        this.icategoryHadler = icategoryHadler;
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        System.out.println(categoryDto.getNombreCateogry());
        icategoryHadler.save(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }


    @GetMapping
    public PaginatedResult<CategoryDto> getArticles(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy,
            @RequestParam boolean ascending) {

        return icategoryHadler.getAllCategory(page, size, sortBy, ascending);
    }


}
