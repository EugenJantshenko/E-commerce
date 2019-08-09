package com.yanchenko.onlineshop.service.impl;

import com.yanchenko.onlineshop.entity.Ware;
import com.yanchenko.onlineshop.entity.WareCategory;
import com.yanchenko.onlineshop.entity.WareType;
import com.yanchenko.onlineshop.repository.WareCategoryRepository;
import com.yanchenko.onlineshop.repository.WareRepository;
import com.yanchenko.onlineshop.repository.WareTypeRepository;
import com.yanchenko.onlineshop.service.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

@Slf4j
@Service
@Transactional(readOnly = true)
public class WareHouseServiceImpl implements WarehouseService {

    private final WareCategoryRepository wareCategoryRepository;
    private final WareRepository wareRepository;
    private final WareTypeRepository wareTypeRepository;
    private Map<String, Integer> cart;

    @Autowired
    public WareHouseServiceImpl(WareRepository wareRepository, WareCategoryRepository wareCategoryRepository, WareTypeRepository wareTypeRepository) {
        this.wareCategoryRepository = wareCategoryRepository;
        this.wareRepository = wareRepository;
        this.wareTypeRepository = wareTypeRepository;
        cart = new HashMap<>();
    }

    //region CRUD Methods
    @Transactional
    @Override
    public boolean createNewWare(Ware ware) {
        if (!wareRepository.existsByWareName(ware.getWareName())) {
            wareRepository.save(ware);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    @Override
    public boolean changeWare(Ware ware) {
        if(wareRepository.existsByWareName(ware.getWareName())){

        }
        return false;
    }

    @Transactional
    @Override
    public boolean deleteWare(String name) {
        if (!wareRepository.existsByWareName(name)) {
            return false;
        }
        Ware currentWare = wareRepository.findByWareName(name);
        wareRepository.delete(currentWare);
        return true;

    }

    @Transactional
    @Override
    public void clearWarehouse() {
        wareRepository.deleteAll();
    }

    @Override
    public List<Ware> showWareList() {
        return wareRepository.findAllByIdIsNotNull();
    }

    @Override
    public List<WareType> showWareTypeList() {
        return wareTypeRepository.findAllByIdIsNotNull();
    }

    @Override
    public List<WareCategory> showWareCategoryList() {
        return wareCategoryRepository.findAllByIdIsNotNull();
    }

    @Transactional
    @Override
    public void setReceievedDate() {
        for (int i = 1; i <= wareRepository.count(); i++) {
            Ware currentWare = wareRepository.getWareById(i);
            currentWare.setReceivedDate(java.sql.Date.valueOf(LocalDate.now()));
            wareRepository.save(currentWare);
        }
    }

    //endregion

    //region Cart Methods
    @Override
    public boolean addWareToCart(String name, Integer count) {
//        if (!checkWareOnWarehouse(name, count)) {
//            log.info("Ware not added to cart");
//            return false;
//        }
//        Ware currentWare = wareRepository.findByWareName(name);
//        cart.put(currentWare.getWareName(), count);
//        log.info("Ware added to cart {} {}", name, count);
//        System.out.println("Ware added to cart {} {}" + name + count);
//        System.out.println(cart.size());
        return true;
    }

    @Override
    public boolean removeWareFromCart(String name) {
        if (!cart.containsKey(name)) {
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
//        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
//            if (checkWareOnWarehouse(entry.getKey(), entry.getValue())) {
//                Ware ware = wareRepository.findByWareName(entry.getKey());
//                ware.setCount(ware.getCount() - entry.getValue());
//                wareRepository.save(ware);
//                System.out.println("Ware was buy in shop");
//                continue;
//            }
//            System.out.println("Ware " + entry.getKey() + " not enough on warehouse");
//            log.info("Ware {0} not enough {1} on warehouse", entry.getKey(), entry.getValue());
//            return false;
//        }
        cart.clear();
        return true;
    }

    @Transactional
    public boolean changeAccess(String name) {
        if (!wareRepository.existsByWareName(name)) {
            return false;
        }
        Ware currentWare = wareRepository.findByWareName(name);
        if (currentWare.getWareType().isBlocked()) {
            currentWare.getWareType().setBlocked(false);
        } else {
            currentWare.getWareType().setBlocked(true);
        }

//        if (currentWare.isBlocked()) {
//            currentWare.setBlocked(false);
//        } else currentWare.setBlocked(false);
        wareRepository.save(currentWare);
        return true;
    }

    @Transactional
    public boolean getTest(String name) {
        Ware currentWare = wareRepository.findByWareName(name);
        System.out.println(currentWare.getWareName());
        return true;
    }
//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


}
