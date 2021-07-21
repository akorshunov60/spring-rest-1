package com.example.springrest1.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductFilter {

    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private String partName;

}
