package com.home.onlineshop.mapper;

import com.home.onlineshop.dto.ManufacturerDto;
import com.home.onlineshop.entity.Manufacturer;
import org.mapstruct.Mapper;

@Mapper
public interface ManufacturerMapper {
    Manufacturer dtoToEntity(ManufacturerDto dto);

    ManufacturerDto entityToDto(Manufacturer man);
}
