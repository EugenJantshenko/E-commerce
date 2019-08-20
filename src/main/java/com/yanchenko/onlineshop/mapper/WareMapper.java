package com.yanchenko.onlineshop.mapper;


import com.yanchenko.onlineshop.dto.WareDto;
import com.yanchenko.onlineshop.entity.Ware;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface WareMapper {

    @Mappings({
            @Mapping(target = "id",source = "dto.id"),
            @Mapping(target = "wareName",source = "dto.wareName"),
            @Mapping(target = "manufacturer",source = "dto.manufacturer"),
            @Mapping(target = "serialNumber",source = "dto.serialNumber"),
            @Mapping(target = "wareType",source = "dto.wareType"),
            @Mapping(target = "wareCount",source = "dto.wareCount"),
            @Mapping(target = "price",source = "dto.price"),
            @Mapping(target = "receivedDate",source = "dto.receivedDate"),
            @Mapping(target = "sealedDate",source = "dto.sealedDate"),
            @Mapping(target = "isSealed",source = "dto.isSealed"),
    })
    Ware wareDtoToWare(WareDto dto);

    @Mappings({
            @Mapping(target = "id",source = "ware.id"),
            @Mapping(target = "wareName",source = "ware.wareName"),
            @Mapping(target = "manufacturer",source = "ware.manufacturer"),
            @Mapping(target = "serialNumber",source = "ware.serialNumber"),
            @Mapping(target = "wareType",source = "ware.wareType"),
            @Mapping(target = "wareCount",source = "ware.wareCount"),
            @Mapping(target = "price",source = "ware.price"),
            @Mapping(target = "receivedDate",source = "ware.receivedDate"),
            @Mapping(target = "sealedDate",source = "ware.sealedDate"),
            @Mapping(target = "isSealed",source = "ware.isSealed"),
    })
    WareDto wareToWareDto(Ware ware);

}
