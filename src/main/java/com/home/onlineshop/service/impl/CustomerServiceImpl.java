package com.home.onlineshop.service.impl;

import com.home.onlineshop.dto.WareDto;
import com.home.onlineshop.exceptions.NotEnoughWareException;
import com.home.onlineshop.repository.WareRepository;
import com.home.onlineshop.service.interfaces.CustomerService;
import com.home.onlineshop.service.interfaces.DBServices.WareCategoryService;
import com.home.onlineshop.service.interfaces.DBServices.WareCountService;
import com.home.onlineshop.service.interfaces.DBServices.WareService;
import com.home.onlineshop.service.interfaces.DBServices.WareTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final WareService wareService;
    private final WareCountService wareCountService;
    private final WareTypeService wareTypeService;
    private final WareCategoryService wareCategoryService;
    private final WareRepository wareRepository;
    private Map<Long, Long> cart;

    @Autowired
    public CustomerServiceImpl(WareService wareService, WareCountService wareCountService, WareTypeService wareTypeService, WareCategoryService wareCategoryService, WareRepository wareRepository) {
        this.wareService = wareService;
        this.wareCountService = wareCountService;
        this.wareTypeService = wareTypeService;
        this.wareCategoryService = wareCategoryService;
        this.wareRepository = wareRepository;
        cart = new HashMap<>();
    }

    //todo make  normal logic
    @Override
    public boolean addWareToCart(WareDto wareDto, Long count) {
        Long balance = wareCountService.getCountById(wareDto.getWareCount().getId());
        Iterable<WareDto> wareList = wareService.getAllByWareName(wareDto.getWareName());
        if (balance >= count) {
            cart.put(wareDto.getWareCount().getId(), count);
            wareDto.setIsSealed(true);
//            wareRepository.save(ware);
        } else throw new NotEnoughWareException();
        return false;
    }

    @Override
    public boolean removeWareFromCart(WareDto wareDto) {
        return false;
    }

    @Override
    public boolean buyWareInCart() {
        return false;
    }

    @Override
    public void clearWarehouse() {

    }
}
