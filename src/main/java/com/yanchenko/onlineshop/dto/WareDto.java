package com.yanchenko.onlineshop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class WareDto  implements Serializable {
    private Integer id;
    private String wareName;
    private String manufacturer;
    private String serialNumber;
    private String wareType;
    private Double price;
    private java.sql.Date receivedDate;
    private java.sql.Date sealedDate;
    private Boolean isSealed;
}
