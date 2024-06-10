package com.example.layeredarchexample.presentation.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;

    private String name;

    private String color;

    private Long quantity;

    private BigDecimal price;

}
