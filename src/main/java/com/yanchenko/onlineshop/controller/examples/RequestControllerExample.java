package com.yanchenko.onlineshop.controller.examples;

import com.yanchenko.onlineshop.dto.RequestDto;
import com.yanchenko.onlineshop.entity.Ware;
import com.yanchenko.onlineshop.repository.WareCategoryRepository;
import com.yanchenko.onlineshop.repository.WareRepository;
import com.yanchenko.onlineshop.repository.WareTypeRepository;
import com.yanchenko.onlineshop.service.impl.WareHouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class RequestControllerExample {

    private final WareRepository wareRepository;
    private final WareCategoryRepository wareCategoryRepository;
    private final WareTypeRepository wareTypeRepository;
    private final WareHouseServiceImpl wareHouseService;

    @Autowired
    public RequestControllerExample(WareRepository wareRepository, WareCategoryRepository wareCategoryRepository, WareTypeRepository wareTypeRepository) {
        this.wareRepository = wareRepository;
        this.wareCategoryRepository = wareCategoryRepository;
        this.wareTypeRepository = wareTypeRepository;
        wareHouseService = new WareHouseServiceImpl(wareRepository, wareCategoryRepository, wareTypeRepository);
    }

    // WareHouseServices methods

    @GetMapping("/testCRUD/createNewWare")
    public boolean createWare() {
        Ware newWare = new Ware();
        newWare.setWareName("TestWare2");
        newWare.setWareType(wareTypeRepository.findWareTypeById(1));
        newWare.setReceivedDate(java.sql.Date.valueOf(LocalDate.now()));
        newWare.setSerialNumber("serial test");
        newWare.setPrice(255);
        return wareHouseService.createNewWare(newWare);
    }

    @PostMapping("/testCRUD/createNewWare")
    public void createNewWare(@RequestBody Ware ware) {
        System.out.println("body: " + ware);
        wareHouseService.createNewWare(ware);
    }


    @GetMapping("/testCRUD/buy")
    public void buyWare() {
        System.out.println("BuyTest");
        wareHouseService.addWareToCart("shoes2", 3);
        wareHouseService.addWareToCart("shoes", 4);
        wareHouseService.byWare();
    }

    @GetMapping("/testCRUD/removeByName")
    public void deleteWare() {
        wareHouseService.deleteWare("five");
    }

//    @GetMapping("/testCRUD/reduceByName")
//    public void reduceWare(){
//        wareHouseService.reduceWare("shoes",2);
//    }

    @GetMapping("/testCRUD/changeAccess")
    public boolean changeAccess() {
        wareHouseService.changeAccess("EnduroHelmet Groove");
        return true;
    }

    @GetMapping("/testCRUD/setReceivedDate")
    public boolean setReceivedDate() {
        wareHouseService.setReceievedDate();
        return true;
    }

    @GetMapping("/testCRUD/Get")
    public boolean getTest() {
        wareHouseService.getTest("EnduroHelmet Groove");
        return true;
    }

    @GetMapping("/{versionId}/test")
    public String getList(@PathVariable("versionId") String pathVariable,
                          @RequestParam("one") String one,
                          @RequestParam(value = "two", required = false) String two) {

        System.out.println("pathVariable: " + pathVariable);
        System.out.println("one: " + one);
        System.out.println("two: " + two);

        return "response from controller ";
    }

    @PostMapping("/products")
    public void postRequest(@RequestBody RequestDto body) {
        System.out.println("body: " + body);
    }


}
