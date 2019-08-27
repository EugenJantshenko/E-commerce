package com.home.onlineshop.service.impl.DBServices;

import com.home.onlineshop.dto.WareDto;
import com.home.onlineshop.mapper.WareMapper;
import com.home.onlineshop.repository.WareRepository;
import com.home.onlineshop.service.interfaces.DBServices.WareService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Service
@Transactional(readOnly = true)
public class WareServiceImpl implements WareService {

    private final WareRepository wareRepository;
    private static WareMapper wareMapper = Mappers.getMapper(WareMapper.class);

    @Autowired
    public WareServiceImpl(WareRepository wareRepository) {
        this.wareRepository = wareRepository;
    }

    @Transactional
    @Override
    public WareDto create(WareDto wareDto) {
        wareDto.setReceivedDate(LocalDateTime.now());
        wareRepository.save(wareMapper.wareDtoToWare(wareDto));
        return wareMapper.wareToWareDto(wareRepository.getWareBySerialNumber(wareDto.getSerialNumber()));
    }

    @Transactional
    @Override
    public WareDto update(WareDto dto) {

        wareRepository.save(wareMapper.wareDtoToWare(dto));
        return wareMapper.wareToWareDto(wareRepository.getWareById(dto.getId()));
    }

    @Transactional
    @Override
    public boolean delete(Long id) {
        if (id != null) {
            if (existsById(id)) {
                wareRepository.deleteById(id);
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterable<WareDto> getAll() {
        return wareMapper.wareToDtoList(wareRepository.findAll());
    }

    @Override
    public Iterable<WareDto> getAllByManufacturer(String manufacturer) {
        return wareMapper.wareToDtoList(wareRepository.findAllByManufacturer(manufacturer));
    }

    @Override
    public boolean existsById(Long id) {
        return wareRepository.existsById(id);
    }
}
