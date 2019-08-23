package com.home.onlineshop.mapper;

import com.home.onlineshop.dto.WareTypeDto;
import com.home.onlineshop.entity.WareType;
import org.mapstruct.Mapper;

@Mapper(uses = WareCategoryMapper.class)
public interface WareTypeMapper {
    WareTypeDto wareTypeToWareTypeDto(WareType wareType);
    WareType wareTypeDtoToWareType(WareTypeDto wareTypeDto);
}
