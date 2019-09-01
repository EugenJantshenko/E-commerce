package com.home.onlineshop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WareTypeDto {
    private Long id;
    private String typeName;
    private WareCategoryDto wareCategory;
    private  boolean isBlocked = false;
}
