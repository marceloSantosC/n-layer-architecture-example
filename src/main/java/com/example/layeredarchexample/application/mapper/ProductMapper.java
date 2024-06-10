package com.example.layeredarchexample.application.mapper;

import com.example.layeredarchexample.data.entity.ProductEntity;
import com.example.layeredarchexample.presentation.dto.NewProductDTO;
import com.example.layeredarchexample.presentation.dto.ProductDTO;

public class ProductMapper {

    public static ProductEntity newProductDTOToProductEntity(NewProductDTO dto) {
        return ProductEntity.builder()
                .color(dto.getColor())
                .name(dto.getName())
                .quantity(dto.getQuantity())
                .price(dto.getPrice())
                .build();

    }

    public static ProductDTO productEntityToProductDTO(ProductEntity entity) {
        return ProductDTO.builder()
                .id(entity.getId())
                .color(entity.getColor())
                .name(entity.getName())
                .quantity(entity.getQuantity())
                .price(entity.getPrice())
                .build();
    }
}
