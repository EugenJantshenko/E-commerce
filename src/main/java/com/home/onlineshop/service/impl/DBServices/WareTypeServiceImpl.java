package com.home.onlineshop.service.impl.DBServices;

import com.home.onlineshop.dto.WareTypeDto;
import com.home.onlineshop.mapper.WareCategoryMapper;
import com.home.onlineshop.mapper.WareTypeMapper;
import com.home.onlineshop.repository.WareCategoryRepository;
import com.home.onlineshop.repository.WareTypeRepository;
import com.home.onlineshop.service.interfaces.DBServices.WareTypeService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
public class WareTypeServiceImpl implements WareTypeService {

    private final WareTypeRepository wareTypeRepository;
    private final WareCategoryRepository wareCategoryRepository;
    private static WareTypeMapper wareTypeMapper = Mappers.getMapper(WareTypeMapper.class);
    private static WareCategoryMapper wareCategoryMapper = Mappers.getMapper(WareCategoryMapper.class);

    @Autowired
    public WareTypeServiceImpl(WareTypeRepository wareTypeRepository,
                               WareCategoryRepository wareCategoryRepository) {
        this.wareTypeRepository = wareTypeRepository;
        this.wareCategoryRepository = wareCategoryRepository;
    }

    @Override
    @Transactional
    public WareTypeDto create(String typeName, Long categoryId) {
        WareTypeDto newDto = new WareTypeDto();
        newDto.setTypeName(typeName);
        newDto.setWareCategory(wareCategoryMapper.categoryToDto(wareCategoryRepository.findById(categoryId).get()));
        wareTypeRepository.save(wareTypeMapper.wareTypeDtoToWareType(newDto));
        return wareTypeMapper.wareTypeToWareTypeDto(wareTypeRepository.findByTypeName(typeName));
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
