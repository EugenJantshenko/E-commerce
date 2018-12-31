package com.home.hibernate.crud.operations.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {
    private String product;
    private Double price;
    @JsonProperty("shops_list")
    private List<String> shopsList;

    public static RequestDtoBuilder builder() {
        return new RequestDtoBuilder();
    }

    public static class RequestDtoBuilder {
        private String product;
        private Double price;
        private List<String> shopsList;

        RequestDtoBuilder() {
        }

        public RequestDtoBuilder product(String product) {
            this.product = product;
            return this;
        }

        public RequestDtoBuilder price(Double price) {
            this.price = price;
            return this;
        }

        public RequestDtoBuilder shopsList(List<String> shopsList) {
            this.shopsList = shopsList;
            return this;
        }

        public RequestDto build() {
            return new RequestDto(product, price, shopsList);
        }

        public String toString() {
            return "RequestDto.RequestDtoBuilder(product=" + this.product + ", price=" + this.price + ", shopsList=" + this.shopsList + ")";
        }
    }
}
