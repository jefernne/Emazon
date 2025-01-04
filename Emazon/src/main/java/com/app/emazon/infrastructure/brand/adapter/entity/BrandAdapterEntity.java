package com.app.emazon.infrastructure.brand.adapter.entity;

import com.app.emazon.domain.brand.model.Brand;
import com.app.emazon.domain.brand.model.PaginateResultBrand;
import com.app.emazon.domain.brand.port.persistence.IBrandPersistence;
import com.app.emazon.infrastructure.brand.adapter.mapper.IBrandMapper;
import com.app.emazon.infrastructure.brand.adapter.respository.IBrandRepository;
import com.app.emazon.infrastructure.brand.entity.BrandEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
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

    @Override
    public PaginateResultBrand<Brand> findAllSortedAndPaginated(int page, int pageSize, String sortField, boolean ascending) {
        Sort sort = ascending ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        PageRequest pageRequest = PageRequest.of(page, pageSize, sort);
        Page<BrandEntity> brandEntities = brandRepository.findAll(pageRequest);
        List<Brand> brands = brandEntities.stream().map(brandMapper::brandEntityToBrand).toList();
        return new PaginateResultBrand<>(brands,
                brandEntities.getNumber(),
                brandEntities.getSize(),
                brandEntities.getTotalElements(),
                brandEntities.getTotalPages(),
                brandEntities.isFirst(),
                brandEntities.isLast());
    }
}
