package com.app.emazon.infrastructure.brand.adapter.entity;

import com.app.emazon.domain.brand.model.Brand;
import com.app.emazon.domain.brand.port.persistence.IBrandPersistence;
import com.app.emazon.infrastructure.brand.adapter.mapper.IBrandMapper;
import com.app.emazon.infrastructure.brand.adapter.respository.IBrandRepository;
import com.app.emazon.infrastructure.brand.entity.BrandEntity;

import java.util.Optional;

public class BrandAdapterEntity implements IBrandPersistence {

    private final IBrandRepository brandRepository;
    private final IBrandMapper brandMapper;

    public BrandAdapterEntity(IBrandRepository brandRepository, IBrandMapper brandMapper) {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }
    @Override
    public void save(Brand brand) {
        try {
            brandRepository.save(brandMapper.brandToBrandEntity(brand));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Brand> findByName(String nameBrand) {
        return brandRepository.findBybrandName(nameBrand).map(BrandEntity -> brandMapper.brandEntityToBrand(BrandEntity) );
    }
}
