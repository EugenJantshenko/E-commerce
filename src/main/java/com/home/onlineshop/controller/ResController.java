package com.home.onlineshop.controller;

import com.home.onlineshop.dto.WareCategoryDto;
import com.home.onlineshop.dto.WareDto;
import com.home.onlineshop.dto.WareTypeDto;
import com.home.onlineshop.service.interfaces.DBServices.WareCategoryService;
import com.home.onlineshop.service.interfaces.DBServices.WareService;
import com.home.onlineshop.service.interfaces.DBServices.WareTypeService;
import com.home.onlineshop.service.interfaces.mailSerivces.SendReportToMail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ResController {

    private final WareCategoryService wareCategoryService;
    private final WareTypeService wareTypeService;
    private final WareService wareService;
    private final SendReportToMail sendReportToMail;

    @Autowired
    public ResController(WareCategoryService wareCategoryService, WareTypeService wareTypeService, WareService wareService, SendReportToMail sendReportToMail) {
        this.wareCategoryService = wareCategoryService;
        this.wareTypeService = wareTypeService;
        this.wareService = wareService;
        this.sendReportToMail = sendReportToMail;
    }

    @GetMapping("/send-mail")
    public void sendMail() throws Exception {
        sendReportToMail.SendEmail("kryoengineer@gmail.com","Test Mail", "Это провреочное писмо по состянию товара на складе");
    }

    @GetMapping("/allWares")
    public Iterable<WareDto> getAllWares() {
        return wareService.getAll();
    }

    @GetMapping("/allTypes")
    public Iterable<WareTypeDto> getAllTypes() {
        return wareTypeService.getAll();
    }

    @GetMapping("/allCategories")
    public Iterable<WareCategoryDto> getAllCategory() {
        return wareCategoryService.getAll();
    }

    @PostMapping("/create-category")
    @ResponseBody
    public WareCategoryDto createCategory(@RequestBody WareCategoryDto wareCategoryDto) {
        return wareCategoryService.create(wareCategoryDto.getCategoryName());
    }

    @PostMapping("/create-type")
    @ResponseBody
    public WareTypeDto createType(@RequestBody WareTypeDto wareTypeDto) {
        return wareTypeService.create(wareTypeDto.getTypeName(), wareTypeDto.getWareCategory().getId());
    }

    @PostMapping("/create-ware")
    @ResponseBody
    public WareDto createWare(@RequestBody WareDto wareDto) {
        return wareService.create(wareDto);
    }

    @PutMapping("/update-ware/{id}")
    @ResponseBody
    public WareDto updateWare(@PathVariable("id") Long id, @RequestBody WareDto wareDto) {
        if (wareService.existsById(id)) {
            wareDto.setId(id);
            return wareService.update(wareDto);
        } else {
            log.warn("No ware with id: " + id);
            return null;
        }
    }

    @GetMapping("/delete-ware/{id}")
    public boolean deleteWare(@PathVariable("id") Long id){
        return wareService.delete(id);
    }

    @GetMapping("/delete-type/{id}")
    public boolean deleteType(@PathVariable("id") Long id){
        return wareTypeService.delete(id);
    }

    @GetMapping("/delete-category/{id}")
    public boolean deleteCategory(@PathVariable("id") Long id){
        return wareCategoryService.delete(id);
    }
}
