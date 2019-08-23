package com.home.onlineshop.controller;

import com.home.onlineshop.dto.WareCategoryDto;
import com.home.onlineshop.dto.WareDto;
import com.home.onlineshop.entity.Ware;
import com.home.onlineshop.mapper.WareMapper;
import com.home.onlineshop.repository.WareCategoryRepository;
import com.home.onlineshop.repository.WareRepository;
import com.home.onlineshop.service.DtoTransformation;
import com.home.onlineshop.service.interfaces.DBServices.WareCategoryService;
import com.home.onlineshop.service.interfaces.WareHouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ResController {

    private final WareRepository wareRepository;
    private final DtoTransformation dtoTransformation;
    private final WareHouseService wareHouseService;
    private final WareCategoryService wareCategoryService;

    @Autowired
    public ResController(WareRepository wareRepository, DtoTransformation dtoTransformation, WareHouseService wareHouseService, WareCategoryRepository wareCategoryRepository, WareCategoryService wareCategoryService) {
        this.wareRepository = wareRepository;
        this.dtoTransformation = dtoTransformation;
        this.wareHouseService = wareHouseService;
        this.wareCategoryService = wareCategoryService;
    }

    @GetMapping("/wares")
    public List<WareDto> getAllWares() {
        Iterable<Ware> wares = wareRepository.findAll();
        List<WareDto> dto = new ArrayList<>();
        for (Ware ware : wares) {
            dto.add(WareMapper.INSTANCE.wareToWareDto(ware));
        }
        return dto;
    }

    @PostMapping("/wareCategory")
    @ResponseBody
    public WareCategoryDto createWare(@ModelAttribute WareCategoryDto wareCategoryDto) {

     return wareCategoryService.create(wareCategoryDto.getCategoryName());
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
