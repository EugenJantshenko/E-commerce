package com.home.onlineshop.mapper;

import com.home.onlineshop.dto.WareNameDto;
import com.home.onlineshop.entity.WareName;
import org.mapstruct.Mapper;

@Mapper
public interface WareNameMapper {
    WareName dtoToEntity(WareNameDto dto);

    WareNameDto entityToDto(WareName name);
}
