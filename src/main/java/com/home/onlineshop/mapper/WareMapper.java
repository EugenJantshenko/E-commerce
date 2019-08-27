package com.home.onlineshop.mapper;


import com.home.onlineshop.dto.WareDto;
import com.home.onlineshop.entity.Ware;
import org.mapstruct.Mapper;

@Mapper(uses = {WareTypeMapper.class, WareCountMapper.class})
public interface WareMapper {

    Ware wareDtoToWare(WareDto dto);

    WareDto wareToWareDto(Ware ware);

    Iterable<WareDto> wareToDtoList(Iterable<Ware> wareList);
}
