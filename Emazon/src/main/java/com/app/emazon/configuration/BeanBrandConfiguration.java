package com.app.emazon.configuration;

import com.app.emazon.application.brand.handler.BrandHandler;
import com.app.emazon.application.brand.handler.IBrandHandler;
import com.app.emazon.application.brand.mapper.IMapperBrand;
import com.app.emazon.application.brand.mapper.ImpMapperBrand;
import com.app.emazon.domain.brand.model.Brand;
import com.app.emazon.domain.brand.port.persistence.IBrandPersistence;
import com.app.emazon.domain.brand.usecase.BrandUseCase;
import com.app.emazon.infrastructure.brand.adapter.entity.BrandAdapterEntity;
import com.app.emazon.infrastructure.brand.adapter.mapper.ImpBrandMapper;
import com.app.emazon.infrastructure.brand.adapter.respository.IBrandRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanBrandConfiguration {

    @Bean
    public BrandAdapterEntity brandAdapter(IBrandRepository iBrandRepository) {
        return new BrandAdapterEntity(iBrandRepository, new ImpBrandMapper());
    }


    @Bean
    public IBrandHandler iBrandHandler(IBrandPersistence ibrandPersistence) {
        return new BrandHandler(new ImpMapperBrand(),new BrandUseCase(ibrandPersistence));
    }

}
