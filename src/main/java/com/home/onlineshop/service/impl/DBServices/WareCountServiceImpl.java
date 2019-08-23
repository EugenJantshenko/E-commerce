package com.home.onlineshop.service.impl.DBServices;

import com.home.onlineshop.service.interfaces.DBServices.WareCountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
public class WareCountServiceImpl implements WareCountService {

    @Override
    public Long getCountById(Long id) {
        return null;
    }
}
