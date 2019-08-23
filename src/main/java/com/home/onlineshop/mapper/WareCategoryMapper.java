package com.home.onlineshop.mapper;

import com.home.onlineshop.dto.WareCategoryDto;
import com.home.onlineshop.entity.WareCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WareCategoryMapper {

    WareCategoryMapper INSTANCE = Mappers.getMapper(WareCategoryMapper.class);

//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "categoryName", source = "categoryName")
    WareCategory dtoToCategory(WareCategoryDto dto);
    WareCategoryDto categoryToDto(WareCategory cat);
}
