package com.home.onlineshop.controller;

import com.home.onlineshop.dto.WareCategoryDto;
import com.home.onlineshop.dto.WareDto;
import com.home.onlineshop.dto.WareTypeDto;
import com.home.onlineshop.service.interfaces.DBServices.WareCategoryService;
import com.home.onlineshop.service.interfaces.DBServices.WareService;
import com.home.onlineshop.service.interfaces.DBServices.WareTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ResController {

    private final WareCategoryService wareCategoryService;
    private final WareTypeService wareTypeService;
    private final WareService wareService;

    @Autowired
    public ResController(WareCategoryService wareCategoryService, WareTypeService wareTypeService, WareService wareService) {
        this.wareCategoryService = wareCategoryService;
        this.wareTypeService = wareTypeService;
        this.wareService = wareService;
    }

    @GetMapping("/wares")
    public List<WareDto> getAllWares() {
        return (List<WareDto>) wareService.getAll();
    }

    @PostMapping("/create-category")
    @ResponseBody
    public WareCategoryDto createCategory(@RequestBody WareCategoryDto wareCategoryDto) {
     return wareCategoryService.create(wareCategoryDto.getCategoryName());
    }

    @PostMapping("/create-type")
    @ResponseBody
    public WareTypeDto createType(@RequestBody WareTypeDto wareTypeDto){
        return wareTypeService.create(wareTypeDto.getTypeName(),wareTypeDto.getWareCategory().getId());
    }

    @PostMapping("/create-ware")
    @ResponseBody
    public WareDto createWare (@RequestBody WareDto wareDto){
        return wareService.create(wareDto);
    }

//    @PostMapping("/wares")
//    @ResponseBody
//    public WareDto createWare(@ModelAttribute WareDto wareDto) {
//        Ware newWare = dtoTransformation.dtoToEntity(wareDto);
//        wareHouseService.createNewWare(newWare);
//        WareDto dto = dtoTransformation.entityToDto(wareRepository.getByWareName(newWare.getWareName()).get());
//        return dto;
//    }
//
//    @PutMapping("/wares/{id}")
//    @ResponseBody
//    public WareDto updateWare(@PathVariable("id") Long id, @ModelAttribute WareDto wareDto){
//        if(wareHouseService.existsWareById(id)){
//            wareHouseService.updateWare(dtoTransformation.dtoToEntity(wareDto));
//            return dtoTransformation.entityToDto(wareHouseService.updateWare(dtoTransformation.dtoToEntity(wareDto)));
//        } else {
//            log.warn("No ware with id: " +id);
//            return null;
//        }
//    }
}
