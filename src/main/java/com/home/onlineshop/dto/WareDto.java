package com.home.onlineshop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class WareDto {
    private Long id;
    private String wareName;
    private String manufacturer;
    private String serialNumber;
    private WareTypeDto wareType;
    private WareCountDto wareCount;
    private Double price;
    private LocalDateTime receivedDate;
    private LocalDateTime sealedDate;
    private Boolean sold;
}
