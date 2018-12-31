package com.home.hibernate.crud.operations.controller;

import com.home.hibernate.crud.operations.dto.RequestDto;
import com.home.hibernate.crud.operations.entity.Ware;
import com.home.hibernate.crud.operations.entity.WareCategory;
import com.home.hibernate.crud.operations.repository.WarCategoryRepository;
import com.home.hibernate.crud.operations.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class RequestController {

    private final WarCategoryRepository warCategoryRepository;
    private final ProductService productService;

    public RequestController(WarCategoryRepository warCategoryRepository, ProductService productService) {
        this.warCategoryRepository = warCategoryRepository;
        this.productService = productService;
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

    @GetMapping
    public String  findIdByName(@RequestParam("name") String name){
        String s = productService.searchByName(name);
        return s;
    }

    @GetMapping("/response")
    public ResponseEntity<RequestDto> doResponse() {

        //do stuff

        RequestDto dto = RequestDto.builder()
                .price(44d)
                .shopsList(Arrays.asList("one", "two", "three"))
                .build();

        return ResponseEntity.status(HttpStatus.OK)
                .body(dto);

    }

    @GetMapping("/test")
    public void test() {
        WareCategory category = new WareCategory();
        category.setCategoryName("test_category");

        Ware ware1 = new Ware();
        ware1.setCount(4);
        ware1.setWareName("four");
        ware1.setPrice(44.4d);
        ware1.setWareCategory(category);

        Ware ware2 = new Ware();
        ware2.setCount(5);
        ware2.setWareName("five");
        ware2.setPrice(55.5d);
        ware2.setWareCategory(category);

        category.setCategory(Arrays.asList(ware1, ware2));

        warCategoryRepository.save(category);


    }

}
