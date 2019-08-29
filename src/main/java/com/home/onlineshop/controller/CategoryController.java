package com.home.onlineshop.controller;


import com.home.onlineshop.dto.WareCategoryDto;
import com.home.onlineshop.service.interfaces.DBServices.WareCategoryService;
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
@RequestMapping("/category")
public class CategoryController {

    private final WareCategoryService wareCategoryService;

    @Autowired
    public CategoryController(WareCategoryService wareCategoryService) {
        this.wareCategoryService = wareCategoryService;
    }

    @GetMapping("/getAll")
    public Iterable<WareCategoryDto> getAllCategory() {
        return wareCategoryService.getAll();
    }


    @PostMapping("/create")
    @ResponseBody
    public WareCategoryDto createCategory(@RequestBody WareCategoryDto wareCategoryDto) {
        return wareCategoryService.create(wareCategoryDto.getCategoryName());
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
      wareCategoryService.delete(id);
    }
}
