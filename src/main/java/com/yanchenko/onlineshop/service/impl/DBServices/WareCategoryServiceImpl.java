package com.yanchenko.onlineshop.service.impl.DBServices;

import com.yanchenko.onlineshop.dto.WareCategoryDto;
import com.yanchenko.onlineshop.service.interfaces.DBServices.WareCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
public class WareCategoryServiceImpl implements WareCategoryService {

    @Override
    @Transactional
    public WareCategoryDto create(String wareCategory) {
        return null;
    }

    @Override
    public List<WareCategoryDto> getAll() {
        return null;
    }
}
