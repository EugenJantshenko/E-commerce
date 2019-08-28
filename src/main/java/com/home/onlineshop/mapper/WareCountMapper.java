package com.home.onlineshop.mapper;

import com.home.onlineshop.dto.WareCountDto;
import com.home.onlineshop.entity.WareCount;
import org.mapstruct.Mapper;

@Mapper
public interface WareCountMapper {
    WareCountDto entityToDto(WareCount wareCount);
    WareCount dtoToEntity(WareCountDto wareCountDto);
}
