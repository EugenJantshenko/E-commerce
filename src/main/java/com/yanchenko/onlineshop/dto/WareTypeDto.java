package com.yanchenko.onlineshop.dto;

import com.yanchenko.onlineshop.entity.WareCategory;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WareTypeDto {

    private Long id;
    private String typeName;
    private WareCategory wareCategory;
    private  boolean isBlocked;
}
