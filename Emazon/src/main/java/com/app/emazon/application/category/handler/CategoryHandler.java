package com.app.emazon.application.category.handler;

import com.app.emazon.application.category.dto.CategoryDto;
import com.app.emazon.application.category.mapper.ImpMapperCategory;
import com.app.emazon.domain.category.error.ErrorMessajeCategory;
import com.app.emazon.domain.category.error.MessageErrorCategory;
import com.app.emazon.domain.category.model.Category;
import com.app.emazon.domain.category.model.PaginatedResult;
import com.app.emazon.domain.category.port.service.IcategoryServicePort;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryHandler implements IcategoryHadler{
    private final IcategoryServicePort icategoryServicePort;
    private final ImpMapperCategory impMapperCategory;

    public CategoryHandler(IcategoryServicePort icategoryServicePort, ImpMapperCategory impMapperCategory) {
        this.icategoryServicePort = icategoryServicePort;
        this.impMapperCategory = impMapperCategory;
    }

    @Override
    public void save(CategoryDto categoryDto) {
        Category category = impMapperCategory.categoryToCategoryDto(categoryDto);
        if(category!=null){
            icategoryServicePort.Save(category);
        }else{
            MessageErrorCategory error = new MessageErrorCategory("empty", ErrorMessajeCategory.CATEGORY_NON_EXISTENT);
        }


    }

    @Override
    public PaginatedResult<CategoryDto> getAllCategory(int page, int pageSize, String sortBy, boolean ascending) {
        PaginatedResult<Category>result = icategoryServicePort.getAllCategory(page, pageSize, sortBy, ascending);
        List<CategoryDto>categoryDTOs = result.getList().stream().map(impMapperCategory::categoryDtoToCategory).collect(Collectors.toList());
        return new PaginatedResult<>(categoryDTOs,
                result.getPageSize(),
                result.getPageNumber(),
                result.getTotalElements(),
                result.isFirst(),
                result.isLast(),
                result.getTotalPages());
    }

}
