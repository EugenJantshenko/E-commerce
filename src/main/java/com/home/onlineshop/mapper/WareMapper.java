package com.home.onlineshop.mapper;


import com.home.onlineshop.dto.WareDto;
import com.home.onlineshop.entity.Ware;
import org.mapstruct.Mapper;

@Mapper(uses = {WareTypeMapper.class, WareCountMapper.class})
public interface WareMapper {

    Ware dtoToEntity(WareDto dto);

    WareDto entityToDto(Ware ware);

}
