package com.home.onlineshop.controller;

import com.home.onlineshop.dto.WareTypeDto;
import com.home.onlineshop.service.ware.WareTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/types")
public class TypeController {

    private final WareTypeService wareTypeService;

    @Autowired
    public TypeController(WareTypeService wareTypeService) {
        this.wareTypeService = wareTypeService;
    }

    @GetMapping
    public Iterable<WareTypeDto> getAllTypes() {
        return wareTypeService.getAll();
    }

    @PostMapping("/create")
    @ResponseBody
    public WareTypeDto createType(@RequestBody WareTypeDto wareTypeDto) {
        return wareTypeService.create(wareTypeDto.getTypeName(), wareTypeDto.getWareCategory().getId());
    }

    @DeleteMapping("/{id}")
    public void deleteType(@PathVariable("id") Long id) {
        wareTypeService.delete(id);
    }

    @GetMapping("/lock/{id}")
    public WareTypeDto lock(@PathVariable("id") Long id){
       return wareTypeService.lock(id);
    }

    @GetMapping("/unlock/{id}")
    public WareTypeDto unlock(@PathVariable("id") Long id){
        return wareTypeService.unlock(id);
    }
}
