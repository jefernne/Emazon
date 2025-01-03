package com.app.emazon.infrastructure.brand.adapter.respository;


import com.app.emazon.infrastructure.brand.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.monitor.StringMonitor;
import java.util.Optional;
@Repository
public interface IBrandRepository extends JpaRepository<BrandEntity, Long> {
    Optional<BrandEntity> findBybrandName(String NameBrand);
}
