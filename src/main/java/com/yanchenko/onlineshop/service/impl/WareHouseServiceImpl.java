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

import java.sql.Date;
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

    public WareType getWareTypeByName(String name){
        return wareTypeRepository.findWareTypeByTypeName(name);
    }


    @Transactional
    @Override
    public boolean createNewWare(Ware ware) {
        if (!wareRepository.existsByWareName(ware.getWareName())) {
            wareRepository.save(ware);
            return true;
        } else {
            log.warn("This ware is already exist");
            return false;
        }
    }

    @Override
    public Ware changeWare(Ware ware) {
        return null;
    }

//    @Transactional
//    @Override
//    public Ware changeWare(Ware ware) {
//        Optional<Ware> byWareName = wareRepository.findByWareName(ware.getWareName());
//        return byWareName.map((item) -> updateWare(ware, item))
//                .orElseThrow(() -> new RuntimeException());


//        if (wareRepository.existsByWareName(ware.getWareName())) {
//            int id = wareRepository.findByWareName(ware.getWareName()).getId();
//            ware.setId(id);
//            wareRepository.save(ware);
//            return true;
//        } else {
//            log.warn(" Cant find ware with id: " + ware.getId());
//            return false;
//        }
//    }

    private Ware updateWare(Ware ware, Ware entity) {
        entity.setWareType(ware.getWareType());
        return entity;
    }

    @Transactional
    @Override
    public boolean deleteWare(String name) {
        if (!wareRepository.existsByWareName(name)) {
            log.warn("There is no item in the warehouse with the name: " + name);
            return false;
        }
        Optional<Ware> currentWare = wareRepository.findByWareName(name);
        wareRepository.delete(currentWare.get());
        return true;
    }

    @Transactional
    @Override
    public boolean deleteWare(Integer id) {
        if (!wareRepository.existsById(id)) {
            log.warn("There is no item in the warehouse with the id: " + id);
            return false;
        }
        Ware currentWare = wareRepository.getWareById(id);
        wareRepository.delete(currentWare);
        return true;
    }

    @Transactional
    @Override
    public boolean createNewWareType(String wareType, Integer categoryId) {
        if (wareTypeRepository.existsWareTypeByTypeName(wareType)) {
            log.warn("Type " + wareType + " is already exist");
            return false;
        } else {
            WareType newType = new WareType();
            newType.setTypeName(wareType);
            Optional<WareCategory> cat = wareCategoryRepository.findById(categoryId);
            newType.setWareCategory(cat.get());
            wareTypeRepository.save(newType);
            return true;
        }
    }

    @Transactional
    @Override
    public boolean createNewWareCategory(String wareCategory) {
        if (wareCategoryRepository.existsWareCategoryByCategoryName(wareCategory)) {
            log.warn("Category " + wareCategory + " is already exist");
            return false;
        } else {
            WareCategory category = new WareCategory();
            category.setCategoryName(wareCategory);
            wareCategoryRepository.save(category);
            return true;
        }
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

    public List<Ware> showManufacturerList(String manufacturer) {
        if (!wareRepository.existsByManufacturer(manufacturer)) {
            log.warn("There is no item in the warehouse with the manufacturer name" + manufacturer);
            return new ArrayList<>();
        } else {
            return wareRepository.findAllByManufacturer(manufacturer);
        }
    }


    @Transactional
    @Override
    public void setReceivedDate(Integer wareID, Date receivedDate) {
        Ware currentWare = wareRepository.getWareById(wareID);
        currentWare.setReceivedDate(receivedDate);
//        wareRepository.save(currentWare);
    }

    @Transactional
    @Override
    public void setSealedDate(Integer wareID, Date sealedDate) {
        Ware currentWare = wareRepository.getWareById(wareID);
        currentWare.setSealedDate(sealedDate);
        wareRepository.save(currentWare);
    }

    @Transactional
    @Override
    public void clearWarehouse() {
        wareRepository.deleteAll();
    }

    @Transactional
    @Override
    public boolean changeAccess(String typeName) {
        if (!wareRepository.existsByWareName(typeName)) {
            return false;
        }
        Optional<Ware> currentWare = wareRepository.findByWareName(typeName);
        if (currentWare.get().getWareType().isBlocked()) {
            currentWare.get().getWareType().setBlocked(false);
        } else {
            currentWare.get().getWareType().setBlocked(true);
        }
        wareRepository.save(currentWare.get());
        return true;
    }

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
            log.info("Cart does not contain chosen ware");
            return false;
        }
        cart.remove(name);
        return true;
    }

    @Transactional
    @Override
    public boolean buyWareInCart() {
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

    public Ware showWareInfo(String name) {
        return new Ware();
    }


    public void filUpTable(){
        createCategory();
        createType();
        createMultipleWares();
        log.info("Table is filled up!");
    }

    @Transactional
    public void createMultipleWares() {
        List<WareType> wareTypeList = wareTypeRepository.findAllByIdIsNotNull();
        for (int i = 1; i <= 60; i++) {
            Ware ware = new Ware();
            ware.setWareName("Ware " + i);
            Random rand = new Random();
            ware.setWareType(wareTypeList.get(rand.nextInt(wareTypeList.size())));
            wareRepository.save(ware);

        }
    }

    @Transactional
    void createType() {
        List<WareCategory> wareCategoryList = wareCategoryRepository.findAllByIdIsNotNull();
        for (int i = 1; i <= 20; i++) {
            WareType type = new WareType();
            type.setTypeName("Type " + i);
            Random rand = new Random();
            type.setWareCategory(wareCategoryList.get(rand.nextInt(wareCategoryList.size())));
            wareTypeRepository.save(type);
        }
    }

    @Transactional
    void createCategory() {
        for (int i = 1; i <= 5; i++) {
            WareCategory category = new WareCategory();
            category.setCategoryName("Category " + i);
            wareCategoryRepository.save(category);
        }
    }
}
