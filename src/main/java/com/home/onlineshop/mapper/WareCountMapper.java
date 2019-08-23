package com.home.onlineshop.mapper;

import com.home.onlineshop.dto.WareCountDto;
import com.home.onlineshop.entity.WareCount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WareCountMapper {

    WareCountMapper INSTANCE = Mappers.getMapper(WareCountMapper.class);

    WareCountDto wareCountToWareCountDto(WareCount wareCount);
    WareCount wareCountDtoToWareCount(WareCountDto wareCountDto);
}
