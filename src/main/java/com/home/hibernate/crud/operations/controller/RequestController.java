package com.home.hibernate.crud.operations.controller;

import com.home.hibernate.crud.operations.dto.RequestDto;
import com.home.hibernate.crud.operations.repository.WareCategoryRepository;
import com.home.hibernate.crud.operations.repository.WareRepository;
import com.home.hibernate.crud.operations.repository.WareTypeRepository;
import com.home.hibernate.crud.operations.service.impl.WareHouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class RequestController {

    private final WareRepository wareRepository;
    private final WareCategoryRepository wareCategoryRepository;
    private final WareTypeRepository wareTypeRepository;
    private final WareHouseServiceImpl wareHouseService;

    @Autowired
    public RequestController(WareRepository wareRepository, WareCategoryRepository wareCategoryRepository, WareTypeRepository wareTypeRepository) {
        this.wareRepository = wareRepository;
        this.wareCategoryRepository = wareCategoryRepository;
        this.wareTypeRepository = wareTypeRepository;
        wareHouseService=new WareHouseServiceImpl(wareRepository,wareCategoryRepository,wareTypeRepository);
    }


    @GetMapping("/{versionId}/test")
    public String getList(@PathVariable("versionId") String pathVariable,
                          @RequestParam("one") String one,
                          @RequestParam(value = "two", required = false) String two) {

        System.out.println("pathVariable: "+ pathVariable);
        System.out.println("one: "+ one);
        System.out.println("two: "+ two);

        return "response from controller ";
    }

    @PostMapping("/products")
    public void postRequest(@RequestBody RequestDto body) {
        System.out.println("body: "+ body);
    }

    @GetMapping("/testCRUD/createNewWare")
    public void createWare() {
        wareHouseService.createWare("helmet1",22d,134,"Motoekip", LocalDateTime.now(),"Givi","Helmets");
    }

    @GetMapping("/testCRUD/addWare")
    public void assWare(){
        wareHouseService.addWare("shoes",8);
    }

    @GetMapping("/testCRUD/buy")
    public void buyWare(){
        System.out.println("BuyTest");
        wareHouseService.addWareToCart("shoes2", 3);
        wareHouseService.addWareToCart("shoes", 4);
        wareHouseService.byWare();
    }

    @GetMapping("/testCRUD/removeByName")
    public void deleteWare(){
        wareHouseService.deleteWare("five");
    }

    @GetMapping("/testCRUD/reduceByName")
    public void reduceWare(){
        wareHouseService.reduceWare("shoes",2);
    }

    @GetMapping("/testCRUD/changeAccess")
    public boolean changeAccess(){
        wareHouseService.changeAccess("EnduroHelmet Groove");
        return true;
    }

    @GetMapping("/testCRUD/setReceivedDate")
    public boolean setReceivedDate(){
        wareHouseService.setReceievedDate();
        return true;
    }

    @GetMapping("/testCRUD/Get")
    public boolean getTest(){
        wareHouseService.getTest("EnduroHelmet Groove");
        return true;
    }

}
