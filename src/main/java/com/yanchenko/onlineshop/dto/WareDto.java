package com.yanchenko.onlineshop.dto;

import com.yanchenko.onlineshop.entity.WareCount;
import com.yanchenko.onlineshop.entity.WareType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class WareDto  implements Serializable {
    private Long id;
    private String wareName;
    private String manufacturer;
    private String serialNumber;
    private WareType wareType;
    private WareCount wareCount;
    private Double price;
    private java.sql.Date receivedDate;
    private java.sql.Date sealedDate;
    private Boolean isSealed;
}
