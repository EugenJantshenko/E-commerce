package com.home.onlineshop.service.impl.DBServices;

import com.home.onlineshop.dto.WareDto;
import com.home.onlineshop.entity.Ware;
import com.home.onlineshop.exceptions.NoSuchWareException;
import com.home.onlineshop.exceptions.WareResourceNotFoundException;
import com.home.onlineshop.mapper.WareMapper;
import com.home.onlineshop.repository.WareRepository;
import com.home.onlineshop.service.interfaces.DBServices.WareService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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

    @Transactional
    @Override
    public WareDto create(WareDto wareDto) {
        if (!wareRepository.existsBySerialNumber(wareDto.getSerialNumber())) {
            wareDto.setReceivedDate(LocalDateTime.now());
            wareDto.setIsSealed(true);
            //System.out.println(wareDto.getIsSealed());
            return wareMapper.entityToDto(wareRepository.save(wareMapper.dtoToEntity(wareDto)));
        }
        throw new WareResourceNotFoundException("SerialNumber is already exist");
    }

    // В процессе реализации
    @Transactional
    @Override
    public WareDto update(WareDto dto) {
        Ware ware = wareRepository.findById(dto.getId()).orElseThrow(NoSuchWareException::new);
        WareDto currentWareDto = wareMapper.entityToDto(ware);
        return wareMapper.entityToDto(wareRepository.save(wareMapper.dtoToEntity(fillTheValues(dto,currentWareDto))));
    }

    @Override
    public Iterable<WareDto> getAll() {
        return StreamSupport.stream(wareRepository.findAll().spliterator(), false)
                .map(wareMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<WareDto> getAllByManufacturer(String manufacturer) {
        return StreamSupport.stream(wareRepository.findAllByManufacturer(manufacturer).spliterator(), false)
                .map(wareMapper::entityToDto)
                .collect(Collectors.toList());

//        return wareMapper.wareToDtoList(wareRepository.findAllByManufacturer(manufacturer));
    }

    @Override
    public boolean existsById(Long id) {
        return wareRepository.existsById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Ware ware = wareRepository.findById(id).orElseThrow(NoSuchWareException::new);
        wareRepository.delete(ware);
    }

    private WareDto fillTheValues(WareDto dto,WareDto currentWare) {
        if (dto.getManufacturer() != null) {
            currentWare.setManufacturer(dto.getManufacturer());
        }
        if (dto.getPrice() != null) {
            currentWare.setPrice(dto.getPrice());
        }
        if(dto.getWareName()!=null){
            currentWare.setWareName(dto.getWareName());
        }
        return currentWare;
    }
}
