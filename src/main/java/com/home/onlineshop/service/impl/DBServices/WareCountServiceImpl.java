package com.home.onlineshop.service.impl.DBServices;

import com.home.onlineshop.mapper.WareCountMapper;
import com.home.onlineshop.repository.WareCountRepository;
import com.home.onlineshop.service.interfaces.DBServices.WareCountService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
public class WareCountServiceImpl implements WareCountService {

    private final WareCountRepository wareCountRepository;
    private static WareCountMapper wareCountMapper = Mappers.getMapper(WareCountMapper.class);

    @Autowired
    public WareCountServiceImpl(WareCountRepository wareCountRepository) {
        this.wareCountRepository = wareCountRepository;
    }

    @Override
    public Long getCountById(Long id) {
        return wareCountRepository.getById(id).getCount();
    }
}
