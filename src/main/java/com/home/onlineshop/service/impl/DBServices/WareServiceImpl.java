package com.home.onlineshop.service.impl.DBServices;

import com.home.onlineshop.dto.WareDto;
import com.home.onlineshop.repository.WareRepository;
import com.home.onlineshop.service.interfaces.DBServices.WareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
public class WareServiceImpl implements WareService {

    private final WareRepository wareRepository;

    @Autowired
    public WareServiceImpl(WareRepository wareRepository) {
        this.wareRepository = wareRepository;
    }

    @Transactional
    @Override
    public WareDto create(WareDto wareDto) {
        return null;
    }

    @Transactional
    @Override
    public WareDto update(WareDto dto) {
        return null;
    }

    @Transactional
    @Override
    public boolean delete(Long id) {
        return true;
    }

    @Override
    public Iterable<WareDto> getAll() {
        return null;
    }

    @Override
    public List<WareDto> getByManufacturer(String manufacturer) {
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        return wareRepository.existsById(id);
    }
}
