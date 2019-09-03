package com.home.onlineshop.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class WareDto implements Serializable {
    private Long id;
    private String wareName;
    private String manufacturer;
    private String serialNumber;
    private WareTypeDto wareType;
    private Double price;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime receivedDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sealedDate;
    private Boolean sold;
}
