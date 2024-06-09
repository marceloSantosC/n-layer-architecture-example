package com.example.layeredarchexample.application.mapper;

import com.example.layeredarchexample.data.entity.ProductEntity;
import com.example.layeredarchexample.presentation.dto.NewProductDTO;

public class ProductMapper {

    public static ProductEntity newProductDTOToProductEntity(NewProductDTO dto) {
        return ProductEntity.builder()
                .color(dto.getColor())
                .name(dto.getName())
                .quantity(dto.getQuantity())
                .price(dto.getPrice())
                .build();

    }

}
