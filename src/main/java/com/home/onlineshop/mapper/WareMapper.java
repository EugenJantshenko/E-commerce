package com.home.onlineshop.mapper;


import com.home.onlineshop.dto.WareDto;
import com.home.onlineshop.entity.Ware;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {WareTypeMapper.class, WareCountMapper.class}, componentModel = "spring")
public interface WareMapper {

    WareMapper INSTANCE = Mappers.getMapper(WareMapper.class);

    //
//    @Mappings({
//            @Mapping(target = "id",source = "dto.id"),
//            @Mapping(target = "wareName",source = "dto.wareName"),
//            @Mapping(target = "manufacturer",source = "dto.manufacturer"),
//            @Mapping(target = "serialNumber",source = "dto.serialNumber"),
//            @Mapping(target = "wareType",source = "dto.wareType"),
//            @Mapping(target = "wareCount",source = "dto.wareCount"),
//            @Mapping(target = "price",source = "dto.price"),
//            @Mapping(target = "receivedDate",source = "dto.receivedDate"),
//            @Mapping(target = "sealedDate",source = "dto.sealedDate"),
//            @Mapping(target = "isSealed",source = "dto.isSealed"),
//    })
    @Mapping(target = "receivedDate", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "sealedDate", dateFormat = "dd-MM-yyyy")
    Ware wareDtoToWare(WareDto dto);

    //    @Mappings({
//            @Mapping(target = "id",source = "ware.id"),
//            @Mapping(target = "wareName",source = "ware.wareName"),
//            @Mapping(target = "manufacturer",source = "ware.manufacturer"),
//            @Mapping(target = "serialNumber",source = "ware.serialNumber"),
//            @Mapping(target = "wareType",source = "ware.wareType"),
//            @Mapping(target = "wareCount",source = "ware.wareCount"),
//            @Mapping(target = "price",source = "ware.price"),
//            @Mapping(target = "receivedDate",source = "ware.receivedDate"),
//            @Mapping(target = "sealedDate",source = "ware.sealedDate"),
//            @Mapping(target = "isSealed",source = "ware.isSealed"),
//    })
    @Mapping(target = "receivedDate", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "sealedDate", dateFormat = "dd-MM-yyyy")
    WareDto wareToWareDto(Ware ware);
}
