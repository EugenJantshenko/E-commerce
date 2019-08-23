package com.home.onlineshop.mapper;

import com.home.onlineshop.dto.WareTypeDto;
import com.home.onlineshop.entity.WareType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = WareCategoryMapper.class, componentModel = "spring")
public interface WareTypeMapper {

    WareTypeMapper INSTANCE = Mappers.getMapper(WareTypeMapper.class);

    WareTypeDto wareTypeToWareTypeDto(WareType wareType);
    WareType wareTypeDtoToWareType(WareTypeDto wareTypeDto);
}
