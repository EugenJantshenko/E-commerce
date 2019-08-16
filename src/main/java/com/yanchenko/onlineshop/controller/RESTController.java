package com.yanchenko.onlineshop.controller;

import com.yanchenko.onlineshop.dto.WareDto;
import com.yanchenko.onlineshop.entity.Ware;
import com.yanchenko.onlineshop.repository.WareRepository;
import com.yanchenko.onlineshop.service.DtoTransformation;
import com.yanchenko.onlineshop.service.impl.WareHouseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest")
public class RESTController {

    private final WareRepository wareRepository;
    private final DtoTransformation dtoTransformation;
    private final WareHouseServiceImpl wareHouseService;

    @Autowired
    public RESTController(WareRepository wareRepository, DtoTransformation dtoTransformation, WareHouseServiceImpl wareHouseService) {
        this.wareRepository = wareRepository;
        this.dtoTransformation = dtoTransformation;
        this.wareHouseService = wareHouseService;
    }

    @GetMapping("/wares")
    public List<WareDto> getAllWares() {
        List<Ware> wares = wareRepository.findAllByIdIsNotNull();
        List<WareDto> dto = new ArrayList<>();
        for (Ware ware : wares) {
            dto.add(dtoTransformation.entityToDto(ware));
        }
        return dto;
    }

    @PostMapping("/wares")
    @ResponseBody
    public WareDto createWare(@ModelAttribute WareDto wareDto) {
        Ware newWare = dtoTransformation.dtoToEntity(wareDto);
        wareHouseService.createNewWare(newWare);
        WareDto dto = dtoTransformation.entityToDto(wareRepository.findByWareName(newWare.getWareName()).get());
        return dto;
    }

}
