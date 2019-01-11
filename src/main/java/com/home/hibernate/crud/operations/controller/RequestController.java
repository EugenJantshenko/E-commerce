package com.home.hibernate.crud.operations.controller;

import com.home.hibernate.crud.operations.dto.RequestDto;
import com.home.hibernate.crud.operations.entity.Ware;
import com.home.hibernate.crud.operations.entity.WareCategory;
import com.home.hibernate.crud.operations.repository.WareCategoryRepository;
import com.home.hibernate.crud.operations.repository.WareRepository;
import com.home.hibernate.crud.operations.service.impl.WareHouseServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class RequestController {

    private final WareRepository wareRepository;
    private final WareCategoryRepository wareCategoryRepository;
    private final WareHouseServiceImpl wareHouseService;

    public RequestController(WareRepository wareRepository, WareCategoryRepository wareCategoryRepository) {
        this.wareRepository = wareRepository;
        this.wareCategoryRepository = wareCategoryRepository;
        wareHouseService=new WareHouseServiceImpl(wareRepository,wareCategoryRepository);
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


//    @GetMapping("/response")
//    public ResponseEntity<RequestDto> doResponse() {
//
//        //do stuff
//
//        RequestDto dto = RequestDto.builder()
//                .price(44d)
//                .shopsList(Arrays.asList("one", "two", "three"))
//                .build();
//
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(dto);
//
//    }

    @GetMapping("/testCRUD/createNewWare")
    public void createWare() {
        wareHouseService.createWare("helmet2",23.2d,15,"Motoekip");
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
        //wareHouseService.changeAccess("shoes2");
        return true;
    }
}
