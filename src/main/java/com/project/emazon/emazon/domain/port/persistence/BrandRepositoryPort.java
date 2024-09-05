package com.project.emazon.emazon.domain.port.persistence;

import com.project.emazon.emazon.domain.model.Brand;


import java.util.List;
import java.util.Optional;

public interface BrandRepositoryPort {
    Brand save(Brand brand);
    Optional<Brand> findByNombre(String name);
    List<Brand> findAllSortedAndPaginated(int page, int size, String sortBy, boolean ascending);
}
