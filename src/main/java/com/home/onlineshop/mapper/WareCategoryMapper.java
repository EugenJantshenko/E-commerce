package com.home.onlineshop.mapper;

import com.home.onlineshop.dto.WareCategoryDto;
import com.home.onlineshop.entity.WareCategory;
import org.mapstruct.Mapper;

@Mapper
public interface WareCategoryMapper {

//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "categoryName", source = "categoryName")
    WareCategory dtoToCategory(WareCategoryDto dto);
    WareCategoryDto categoryToDto(WareCategory cat);
}
