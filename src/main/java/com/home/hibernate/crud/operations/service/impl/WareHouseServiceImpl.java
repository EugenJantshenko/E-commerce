package com.home.hibernate.crud.operations.service.impl;

import com.home.hibernate.crud.operations.entity.Ware;
import com.home.hibernate.crud.operations.entity.WareCategory;
import com.home.hibernate.crud.operations.repository.WareCategoryRepository;
import com.home.hibernate.crud.operations.repository.WareRepository;
import com.home.hibernate.crud.operations.service.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@Transactional(readOnly = true)
public class WareHouseServiceImpl implements WarehouseService {

    private final WareCategoryRepository wareCategoryRepository;
    private final WareRepository wareRepository;
    private Map<String, Integer> cart;

    @Autowired
    public WareHouseServiceImpl(WareRepository repository,WareCategoryRepository wareCategoryRepository) {
        this.wareCategoryRepository = wareCategoryRepository;
        this.wareRepository = repository;
        cart = new HashMap<>();
    }

    @Transactional
    @Override
    public boolean createWare(String name, double price, Integer count, String categoryName) {
        WareCategory category = new WareCategory();
        category.setCategoryName(categoryName);

        Ware ware1 = new Ware();
        ware1.setCount(count);
        ware1.setWareName(name);
        ware1.setPrice(price);
        ware1.setWareCategory(category);

        category.setCategory(Arrays.asList(ware1));

        wareCategoryRepository.save(category);
        return true;
    }

    @Transactional
    @Override
    public boolean addWare(String name, Integer count) {
        if (!wareRepository.existsByWareName(name)) {
            return false;
        }
        Ware currentWare = wareRepository.findByWareName(name);
        currentWare.setCount(currentWare.getCount() + count);
        wareRepository.save(currentWare);
        return true;
    }

    @Transactional
    @Override
    public boolean reduceWare(String name, Integer count) {
        if (!checkWareOnWarehouse(name, count)) {
            return false;
        }
        Ware currentWare = wareRepository.findByWareName(name);
        currentWare.setCount(currentWare.getCount() - count);
        wareRepository.save(currentWare);
        return true;
    }

    @Transactional
    @Override
    public boolean deleteWare(String name) {
        if (!wareRepository.existsByWareName(name)) {
            return false;
        }
        Ware currentWare=wareRepository.findByWareName(name);
        wareRepository.delete(currentWare);
        return true;

    }

    @Transactional
    @Override
    public void clearWarehouse() {
        wareRepository.deleteAll();
        //context.close();
    }

    private boolean checkWareOnWarehouse(String name, Integer count) {
        if (wareRepository.existsByWareName(name) &&
                (wareRepository.findByWareName(name).getCount() > count)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addWareToCart(String name, Integer count) {
        if (!checkWareOnWarehouse(name, count)) {
            log.info("Ware not added to cart");
            return false;
        }
        Ware currentWare = wareRepository.findByWareName(name);
        cart.put(currentWare.getWareName(), count);
        log.info("Ware added to cart {} {}", name, count);
        System.out.println("Ware added to cart {} {}"+ name + count);
        System.out.println(cart.size());
        return true;
    }

    @Override
    public boolean removeWareFromCart(String name) {
        if(!cart.containsKey(name)){
            log.info("Cart dosent contain chosen ware");
            return false;
        }
        cart.remove(name);
        return true;
    }

    @Transactional
    @Override
    public boolean byWare() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
            return false;
        }
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            if (checkWareOnWarehouse(entry.getKey(), entry.getValue())) {
                Ware ware=wareRepository.findByWareName(entry.getKey());
                ware.setCount(ware.getCount()-entry.getValue());
                wareRepository.save(ware);
                System.out.println("Ware was buy in shop");
                continue;
            }
            System.out.println("Ware " + entry.getKey() + " not enough on warehouse");
            log.info("Ware {0} not enough {1} on warehouse", entry.getKey(), entry.getValue());
            return false;
        }
        cart.clear();
        return true;
    }

    @Transactional
    public boolean changeAccess(String name){
        if (!wareRepository.existsByWareName(name)) {
            return false;
        }
        Ware currentWare=wareRepository.findByWareName(name);
        if(currentWare.isBlocked()){
            currentWare.setBlocked(false);
        }
        else currentWare.setBlocked(false);
        wareRepository.save(currentWare);
        return true;
    }
}
