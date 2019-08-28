package com.home.onlineshop.mapper;

import com.home.onlineshop.dto.WareCategoryDto;
import com.home.onlineshop.entity.WareCategory;
import org.mapstruct.Mapper;

@Mapper
public interface WareCategoryMapper {

    WareCategory dtoToEntity(WareCategoryDto dto);

    WareCategoryDto entityToDto(WareCategory cat);

}
