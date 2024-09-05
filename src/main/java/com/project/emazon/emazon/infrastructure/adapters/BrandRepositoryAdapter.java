package com.project.emazon.emazon.infrastructure.adapters;

import com.project.emazon.emazon.domain.model.Brand;
import com.project.emazon.emazon.domain.port.persistence.BrandRepositoryPort;
import com.project.emazon.emazon.infrastructure.entities.BrandEntity;
import com.project.emazon.emazon.infrastructure.entities.CategoryEntity;
import com.project.emazon.emazon.infrastructure.mappers.BrandMapper;
import com.project.emazon.emazon.infrastructure.repositories.JpaBrandRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class BrandRepositoryAdapter implements BrandRepositoryPort{
    private final JpaBrandRepository jpaBrandRepository;

    public BrandRepositoryAdapter(JpaBrandRepository jpaBrandRepository) {
        this.jpaBrandRepository = jpaBrandRepository;
    }

    @Override
    public Brand save(Brand brand) {
        BrandEntity brandEntity =  jpaBrandRepository.save(BrandMapper.toBradEntity(brand));
        return BrandMapper.toBrand(brandEntity);
    }

    @Override
    public Optional<Brand> findByNombre(String name) {
        return Optional.empty();
    }

    @Override
    public List<Brand> findAllSortedAndPaginated(int page, int size, String sortBy, boolean ascending) {
        return List.of();
    }
}




