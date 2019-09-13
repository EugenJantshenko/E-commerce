package com.home.onlineshop.controller;

import com.home.onlineshop.dto.WareDto;
import com.home.onlineshop.service.ware.WareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wares")
public class WareController {

    private final WareService wareService;

    @Autowired
    public WareController(WareService wareService) {
        this.wareService = wareService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping
    public Iterable<WareDto> getAllWares() {
        return wareService.getAll();
    }

    @GetMapping("/count")
    public Long getCount(@RequestParam("name") Long name) {
        return wareService.getAllByWareName(name).spliterator().getExactSizeIfKnown();
    }

    @PostMapping("/create")
    @ResponseBody
    public WareDto createWare(@RequestBody WareDto wareDto) {
        return wareService.create(wareDto);
    }

    @PutMapping("/update")
    @ResponseBody
    public WareDto updateWare(@RequestBody WareDto wareDto) {
        return wareService.update(wareDto);
    }

    @DeleteMapping("/{id}")
    public void deleteWare(@PathVariable("id") Long id) {
        wareService.delete(id);
    }
}
