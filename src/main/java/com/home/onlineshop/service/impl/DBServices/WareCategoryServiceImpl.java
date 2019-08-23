package com.home.onlineshop.service.impl.DBServices;

import com.home.onlineshop.dto.WareCategoryDto;
import com.home.onlineshop.mapper.WareCategoryMapper;
import com.home.onlineshop.repository.WareCategoryRepository;
import com.home.onlineshop.service.interfaces.DBServices.WareCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
public class WareCategoryServiceImpl implements WareCategoryService {

    private final WareCategoryRepository wareCategoryRepository;

    @Autowired
    public WareCategoryServiceImpl(WareCategoryRepository wareCategoryRepository) {
        this.wareCategoryRepository = wareCategoryRepository;
    }

    @Override
    @Transactional
    public WareCategoryDto create(String wareCategoryName) {
        WareCategoryDto newDto= new WareCategoryDto();
        newDto.setCategoryName(wareCategoryName);
        wareCategoryRepository.save(WareCategoryMapper.INSTANCE.dtoToCategory(newDto));
        return WareCategoryMapper.INSTANCE.categoryToDto(wareCategoryRepository.findByCategoryName(wareCategoryName));
    }

    @Override
    public List<WareCategoryDto> getAll() {
        return null;
    }
}
