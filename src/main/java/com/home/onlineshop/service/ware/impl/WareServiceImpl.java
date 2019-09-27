package com.home.onlineshop.service.ware.impl;

import com.home.onlineshop.dto.WareDto;
import com.home.onlineshop.entity.Ware;
import com.home.onlineshop.exceptions.NoSuchWareException;
import com.home.onlineshop.exceptions.WareAlreadyExistException;
import com.home.onlineshop.mapper.WareMapper;
import com.home.onlineshop.repository.WareRepository;
import com.home.onlineshop.service.ware.WareService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional(readOnly = true)
public class WareServiceImpl implements WareService {

    private final WareRepository wareRepository;
    private static WareMapper wareMapper = Mappers.getMapper(WareMapper.class);

    @Autowired
    public WareServiceImpl(WareRepository wareRepository) {
        this.wareRepository = wareRepository;
    }

    @Override
    @Transactional
    public WareDto create(WareDto dto) {
        Optional<Ware> wareEntity = wareRepository.findBySerialNumber(dto.getSerialNumber());
        if (wareEntity.isPresent()) {
            throw new WareAlreadyExistException(String.format("ware with serial number %s already exist", dto.getSerialNumber()));
        }
        Ware ware = wareMapper.dtoToEntity(dto);
        ware.setReceivedDate(LocalDateTime.now());
        return wareMapper.entityToDto(wareRepository.save(ware));
    }

    @Override
    @Transactional
    public WareDto update(@org.jetbrains.annotations.NotNull WareDto dto) {
        Optional<Ware> wareEntity=wareRepository.findById(dto.getId());
        if(!wareEntity.isPresent()){
            throw new NoSuchWareException();
        }
        Ware ware = wareMapper.dtoToEntity(dto);
        return wareMapper.entityToDto(wareRepository.save(ware));
    }

    @Override
    public Iterable<WareDto> getAll() { //think about pagination
        return StreamSupport.stream(wareRepository.findAll().spliterator(), false)
                .map(wareMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<WareDto> getAllByManufacturer(Long manufacturer) {
        return StreamSupport.stream(wareRepository.findAllByManufacturerId(manufacturer).spliterator(), false)
                .map(wareMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<WareDto> getAllByWareName(Long wareName) {
        return StreamSupport.stream(wareRepository.findAllByNameId(wareName).spliterator(), false)
                .map(wareMapper::entityToDto)
                .collect((Collectors.toList()));
    }

    @Override
    public boolean existByNameId(Long id) {
        return wareRepository.existsByNameId(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Ware ware = wareRepository.findById(id).orElseThrow(NoSuchWareException::new);
        wareRepository.delete(ware);
    }
}
