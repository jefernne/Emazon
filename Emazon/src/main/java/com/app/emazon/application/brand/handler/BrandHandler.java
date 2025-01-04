package com.app.emazon.application.brand.handler;

import com.app.emazon.application.brand.dto.BrandDto;
import com.app.emazon.application.brand.mapper.IMapperBrand;
import com.app.emazon.application.category.dto.CategoryDto;
import com.app.emazon.domain.brand.error.ErrorMessajeBrand;
import com.app.emazon.domain.brand.error.InvalidBrandeExection;
import com.app.emazon.domain.brand.error.MessageErrorBrand;
import com.app.emazon.domain.brand.model.Brand;
import com.app.emazon.domain.brand.model.PaginateResultBrand;
import com.app.emazon.domain.brand.port.service.IBrandServices;

import java.util.ArrayList;
import java.util.List;

public class BrandHandler implements IBrandHandler{
    private final IMapperBrand iMapperBrand;
    private final IBrandServices iBrandServices;
    public BrandHandler(IMapperBrand iMapperBrand, IBrandServices iBrandServices) {
        this.iMapperBrand = iMapperBrand;
        this.iBrandServices = iBrandServices;
    }

    @Override
    public void save(BrandDto brandDto) {
        Brand  brand = iMapperBrand.BrandDtoToBrand(brandDto);
        if(brand == null) {
            List<MessageErrorBrand> list = new ArrayList<>();
            list.add(new MessageErrorBrand("Brand", ErrorMessajeBrand.BRAND_WITH_EMPTY_FIELDS));
            throw new InvalidBrandeExection("NULL DATA",list );
        }
        iBrandServices.Save(brand);

    }

    @Override
    public PaginateResultBrand<BrandDto> getAllBrands(int page, int pageSize, String sortBy, boolean ascending) {
        PaginateResultBrand<Brand> result = iBrandServices.findAllSortedAndPaginated(page, pageSize, sortBy, ascending);
        List<BrandDto> BrandDtos = result.getList().stream().map(iMapperBrand::BrandToBrandDto).toList();
        return new PaginateResultBrand<>(BrandDtos,result.getPageNumber(),result.getPageSize(),result.getTotalElements(), result.getTotalPages(),result.isFirst(),result.isLast());
    }
}
