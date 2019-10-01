package com.home.onlineshop.service.customer.impl;

import com.home.onlineshop.entity.Cart;
import com.home.onlineshop.entity.Ware;
import com.home.onlineshop.exceptions.EmptyCartException;
import com.home.onlineshop.exceptions.WareResourceNotFoundException;
import com.home.onlineshop.repository.WareRepository;
import com.home.onlineshop.service.customer.CustomerService;
import com.home.onlineshop.service.ware.WareCategoryService;
import com.home.onlineshop.service.ware.WareService;
import com.home.onlineshop.service.ware.WareTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    private final WareService wareService;
    private final WareTypeService wareTypeService;
    private final WareCategoryService wareCategoryService;
    private final WareRepository wareRepository;
//    private Map<Long, Long> cart = new HashMap<>();

    @Autowired
    public CustomerServiceImpl(WareService wareService,
                               WareTypeService wareTypeService,
                               WareCategoryService wareCategoryService,
                               WareRepository wareRepository) {
        this.wareService = wareService;
        this.wareTypeService = wareTypeService;
        this.wareCategoryService = wareCategoryService;
        this.wareRepository = wareRepository;
    }

    @Override
    public boolean addToCart(Cart cart, Long nameId, Long count) {
        if (!wareService.existByNameId(nameId)) {
            throw new WareResourceNotFoundException();
        }
        if (checkAvailableQuantity(nameId, count)) {
            cart.addWareToCart(nameId, count);
        }
        return true;
    }

    @Override
    public boolean removeFromCart(Cart cart, Long wareNameId) {
        if (cart.containsKey(wareNameId)) {
            cart.removeWare(wareNameId);
            return true;
        }
        return false;
    }

    @Override
    public void clearCart(Cart cart) {
        cart.clear();
    }

    @Override
    @Transactional
    public boolean buyWares(Cart cart) {
        if (cart.isEmpty()) {
            throw new EmptyCartException();
        }
        Pageable pageable = PageRequest.of(0, 4);
        for (Map.Entry<Long, Long> pair : cart.getWareMap().entrySet()) {
            Iterable<Ware> allByNameIdAndSoldIsFalse = wareRepository.findAllByNameIdAndSoldIsFalse(pair.getKey(), pageable);
            Long count = pair.getValue();
            int iter = 0;
            for (Ware ware : allByNameIdAndSoldIsFalse) {
                if (iter++ < count) {
                    ware.setSold(true);
                }
            }
        }
        return true;
    }

    private boolean checkAvailableQuantity(Long wareNameId, Long count) {
        Long less = wareRepository.findAllByNameIdAndSoldIsFalse(wareNameId).spliterator().getExactSizeIfKnown();
        return less > count;
    }

}
