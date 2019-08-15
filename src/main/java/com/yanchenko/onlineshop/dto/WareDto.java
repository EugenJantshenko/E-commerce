package com.yanchenko.onlineshop.dto;

import com.yanchenko.onlineshop.entity.WareType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
public class WareDto {
    private Integer id;
    private String wareName;
    private String serialNumber;
    private String wareType;
    private Double price;
    private java.sql.Date receivedDate;
    private java.sql.Date sealedDate;
    private Boolean isSealed;
}
