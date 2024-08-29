package com.project.emazon.emazon.infrastructure.repositories;

import com.project.emazon.emazon.infrastructure.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface JpaCategoryRepository extends JpaRepository <CategoryEntity, Long>{
    Optional<CategoryEntity> findByName(String name);
}
