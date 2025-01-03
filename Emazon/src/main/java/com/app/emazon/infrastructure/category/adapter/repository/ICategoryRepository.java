package com.app.emazon.infrastructure.category.adapter.repository;

import com.app.emazon.infrastructure.category.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findBynombreCateogry(String nombreCateogry);
}
