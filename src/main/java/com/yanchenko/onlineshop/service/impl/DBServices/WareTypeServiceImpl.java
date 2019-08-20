package com.yanchenko.onlineshop.service.impl.DBServices;

import com.yanchenko.onlineshop.dto.WareTypeDto;
import com.yanchenko.onlineshop.repository.WareCategoryRepository;
import com.yanchenko.onlineshop.repository.WareTypeRepository;
import com.yanchenko.onlineshop.service.interfaces.DBServices.WareTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
public class WareTypeServiceImpl implements WareTypeService {

    private final WareTypeRepository wareTypeRepository;
    private final WareCategoryRepository wareCategoryRepository;

    @Autowired
    public WareTypeServiceImpl(WareTypeRepository wareTypeRepository,
                               WareCategoryRepository wareCategoryRepository) {
        this.wareTypeRepository = wareTypeRepository;
        this.wareCategoryRepository = wareCategoryRepository;
    }

    @Override
    @Transactional
    public WareTypeDto create(String typeName, Long categoryId) {
        return null;
    }

    @Override
    public Iterable<WareTypeDto> getAll() {
        return null;
    }

    @Override
    public boolean block(String typeName) {
        return false;
    }

    @Override
    public boolean unblock(String typeName) {
        return false;
    }


}
