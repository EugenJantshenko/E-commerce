package com.yanchenko.onlineshop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WareTypeForm {
    private String fullName;
    private Long typeId;
}
