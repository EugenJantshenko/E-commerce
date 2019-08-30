package com.home.onlineshop.controller;

import com.home.onlineshop.dto.WareDto;
import com.home.onlineshop.service.interfaces.DBServices.WareCountService;
import com.home.onlineshop.service.interfaces.DBServices.WareService;
import com.home.onlineshop.service.interfaces.mailSerivces.SendReportToMail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/ware")
public class WareController {

    private final WareService wareService;
    private final WareCountService wareCountService;
    private final SendReportToMail sendReportToMail;

    @Autowired
    public WareController(WareService wareService, WareCountService wareCountService, SendReportToMail sendReportToMail) {
        this.wareService = wareService;
        this.wareCountService = wareCountService;
        this.sendReportToMail = sendReportToMail;
    }

    @GetMapping("/send-mail")
    public void sendMail() throws Exception {
        sendReportToMail.sendEmail("kryoengineer@gmail.com", "Test Mail", "Это провреочное писмо по состянию товара на складе");
    }

    @GetMapping("/getAll")
    public Iterable<WareDto> getAllWares() {
        return wareService.getAll();
    }

    @GetMapping("/getCount/{id}")
    public Long getCount(@PathVariable("id") Long id){
        return wareCountService.getCountById(id);
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

    @PutMapping("/setSealedDate/{id}")
    @ResponseBody
    public WareDto setSealedDate(@PathVariable("id") Long id, @RequestBody WareDto wareDto){
        wareDto.setId(id);
        return wareService.setSealedDate(wareDto);
    }

    @DeleteMapping("/{id}")
    public void deleteWare(@PathVariable("id") Long id) {
        wareService.delete(id);
    }


}
