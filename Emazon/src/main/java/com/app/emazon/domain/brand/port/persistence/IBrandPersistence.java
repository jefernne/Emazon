package com.app.emazon.domain.brand.port.persistence;

import com.app.emazon.domain.brand.model.Brand;
import com.app.emazon.domain.category.model.Category;

import java.util.Optional;

public interface IBrandPersistence {
    void save(Brand brand);
    Optional<Brand> findByName(String name);
}
