package com.project.emazon.emazon.infrastructure.repositories;


import com.project.emazon.emazon.infrastructure.entities.BrandEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaBrandRepository extends JpaRepository<BrandEntity, Long> {
    Optional<BrandEntity> findByName(String name);
}
