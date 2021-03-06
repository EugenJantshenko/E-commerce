package com.home.onlineshop.service.ware.impl;

import com.home.onlineshop.dto.WareTypeDto;
import com.home.onlineshop.entity.WareCategory;
import com.home.onlineshop.entity.WareType;
import com.home.onlineshop.exceptions.NoSuchWareTypeException;
import com.home.onlineshop.exceptions.WareResourceNotFoundException;
import com.home.onlineshop.mapper.WareCategoryMapper;
import com.home.onlineshop.mapper.WareTypeMapper;
import com.home.onlineshop.repository.WareCategoryRepository;
import com.home.onlineshop.repository.WareTypeRepository;
import com.home.onlineshop.service.ware.WareTypeService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
@Transactional(readOnly = true)
public class WareTypeServiceImpl implements WareTypeService {

    private final WareTypeRepository wareTypeRepository;
    private final WareCategoryRepository wareCategoryRepository;
    private static WareTypeMapper wareTypeMapper = Mappers.getMapper(WareTypeMapper.class);
    private static WareCategoryMapper wareCategoryMapper = Mappers.getMapper(WareCategoryMapper.class);  //remove

    @Autowired
    public WareTypeServiceImpl(WareTypeRepository wareTypeRepository,
                               WareCategoryRepository wareCategoryRepository) {
        this.wareTypeRepository = wareTypeRepository;
        this.wareCategoryRepository = wareCategoryRepository;
    }

    @Override
    @Transactional
    public WareTypeDto create(String typeName, Long categoryId) {
        if (!wareTypeRepository.existsByTypeName(typeName)) {  //change to fail fast
            WareCategory wareCategory = wareCategoryRepository.findById(categoryId)  //check for duplicates for ware type
                    .orElseThrow(WareResourceNotFoundException::new);
            WareType wareType = new WareType();
            wareType.setTypeName(typeName);
            wareType.setWareCategory(wareCategory);
            WareType ware = wareTypeRepository.save(wareType);
            return wareTypeMapper.entityToDto(ware);
        }
        throw new WareResourceNotFoundException("type already exist");
    }

    @Override
    public Iterable<WareTypeDto> getAll() {
        return StreamSupport.stream(wareTypeRepository.findAll().spliterator(), false)
                .map(wareTypeMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public WareTypeDto lock(Long id) {
        WareType type = wareTypeRepository.findById(id).orElseThrow(NoSuchWareTypeException::new);
        type.setBlocked(true);
        return wareTypeMapper.entityToDto(type);
    }

    @Override
    @Transactional
    public WareTypeDto unlock(Long id) {
        WareType type = wareTypeRepository.findById(id).orElseThrow(NoSuchWareTypeException::new);
        type.setBlocked(false);
        return wareTypeMapper.entityToDto(type);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        WareType type = wareTypeRepository.findById(id).orElseThrow(NoSuchWareTypeException::new);
        wareTypeRepository.delete(type);
    }
}
