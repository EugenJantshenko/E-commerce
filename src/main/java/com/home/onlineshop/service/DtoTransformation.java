package com.home.onlineshop.service;

import com.home.onlineshop.dto.WareDto;
import com.home.onlineshop.service.impl.WareHouseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DtoTransformation {


    private final WareHouseServiceImpl wareHouseService;

    public DtoTransformation(WareHouseServiceImpl wareHouseService) {
        this.wareHouseService = wareHouseService;
    }

//    public WareDto entityToDto (Ware ware){
//        WareDto dto =new WareDto();
//        dto.setId(ware.getId());
//        dto.setIsSealed(ware.isSealed());
//        dto.setManufacturer(ware.getManufacturer());
//        dto.setPrice(ware.getPrice());
//        dto.setReceivedDate(ware.getReceivedDate());
//        dto.setSealedDate(ware.getSealedDate());
//        dto.setSerialNumber(ware.getSerialNumber());
//        dto.setWareName(ware.getWareName());
//        dto.setWareType(ware.getWareType().getTypeName());
//        return dto;
//    }
//
//    public Ware dtoToEntity(WareDto dto){
//        validate(dto);
//        Ware ware=new Ware();
//        ware.setId(dto.getId());
//      //  ware.setSealed(dto.getIsSealed());
//        ware.setManufacturer(dto.getManufacturer());
//        ware.setPrice(dto.getPrice());
//        ware.setReceivedDate(dto.getReceivedDate());
//        ware.setSealedDate(dto.getSealedDate());
//        ware.setSerialNumber(dto.getSerialNumber());
//        ware.setWareName(dto.getWareName());
//        ware.setWareType(wareHouseService.getWareTypeByName(dto.getWareType()));
//        return ware;
//    }

    private void validate(WareDto dto){

    }
}
