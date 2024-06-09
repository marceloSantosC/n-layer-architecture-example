package com.example.layeredarchexample.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewProductDTO {

    private String name;

    private String color;

    private Long quantity;

    private BigDecimal price;

}
