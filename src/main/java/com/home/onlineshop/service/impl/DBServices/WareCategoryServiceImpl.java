package com.home.onlineshop.service.impl.DBServices;

import com.home.onlineshop.dto.WareCategoryDto;
import com.home.onlineshop.entity.WareCategory;
import com.home.onlineshop.exceptions.NoSuchWareCategoryException;
import com.home.onlineshop.exceptions.WareResourceNotFoundException;
import com.home.onlineshop.mapper.WareCategoryMapper;
import com.home.onlineshop.repository.WareCategoryRepository;
import com.home.onlineshop.service.interfaces.DBServices.WareCategoryService;
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
public class WareCategoryServiceImpl implements WareCategoryService {
    private final WareCategoryRepository wareCategoryRepository;
    private static WareCategoryMapper wareCategoryMapper = Mappers.getMapper(WareCategoryMapper.class);

    @Autowired
    public WareCategoryServiceImpl(WareCategoryRepository wareCategoryRepository) {
        this.wareCategoryRepository = wareCategoryRepository;
    }

    @Override
    @Transactional
    public WareCategoryDto create(String wareCategoryName) {
       if(!wareCategoryRepository.existsByCategoryName(wareCategoryName)){
           WareCategory category=new WareCategory();
           category.setCategoryName(wareCategoryName);
           WareCategory createdCategory = wareCategoryRepository.save(category);
           return wareCategoryMapper.entityToDto(createdCategory);
       }
       throw new WareResourceNotFoundException("Category already exist");
    }

    @Override
    public Iterable<WareCategoryDto> getAll() {
        return StreamSupport.stream(wareCategoryRepository.findAll().spliterator(),false)
                .map(wareCategoryMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        WareCategory cat = wareCategoryRepository.findById(id).orElseThrow(NoSuchWareCategoryException::new);
        wareCategoryRepository.delete(cat);
    }
}
