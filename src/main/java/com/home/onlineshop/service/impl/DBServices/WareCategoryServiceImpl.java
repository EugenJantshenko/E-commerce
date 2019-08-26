package com.home.onlineshop.service.impl.DBServices;

import com.home.onlineshop.dto.WareCategoryDto;
import com.home.onlineshop.entity.WareCategory;
import com.home.onlineshop.mapper.WareCategoryMapper;
import com.home.onlineshop.repository.WareCategoryRepository;
import com.home.onlineshop.service.interfaces.DBServices.WareCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
public class WareCategoryServiceImpl implements WareCategoryService {
    private final WareCategoryRepository wareCategoryRepository;
    private static  WareCategoryMapper wareCategoryMapper = Mappers.getMapper(WareCategoryMapper.class);

    @Autowired
    public WareCategoryServiceImpl(WareCategoryRepository wareCategoryRepository) {
        this.wareCategoryRepository = wareCategoryRepository;
    }

    @Override
    @Transactional
    public WareCategoryDto create(String wareCategoryName) {
        WareCategoryDto newDto = new WareCategoryDto();
        newDto.setCategoryName(wareCategoryName);
        wareCategoryRepository.save(wareCategoryMapper.dtoToCategory(newDto));
        return wareCategoryMapper.categoryToDto(wareCategoryRepository.findByCategoryName(wareCategoryName));
    }

    @Override
    public Iterable<WareCategory> getAll() {
        return wareCategoryRepository.findAll();
    }
}
