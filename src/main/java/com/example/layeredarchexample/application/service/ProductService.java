package com.example.layeredarchexample.application.service;

import com.example.layeredarchexample.application.exception.ServiceException;
import com.example.layeredarchexample.application.mapper.ProductMapper;
import com.example.layeredarchexample.data.entity.ProductEntity;
import com.example.layeredarchexample.data.repository.ProductRepository;
import com.example.layeredarchexample.presentation.dto.NewProductDTO;
import com.example.layeredarchexample.presentation.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Long registerProduct(NewProductDTO newProductDTO) {

        productRepository.findByName(newProductDTO.getName()).ifPresent((product) -> {
            log.error("Product with name {} already exists.", product.getName());
            throw new ServiceException("Error when trying to register product: product already exists.");
        });

        ProductEntity product = ProductMapper.newProductDTOToProductEntity(newProductDTO);
        productRepository.save(product);
        return product.getId();
    }

    public Optional<ProductDTO> getProduct(Long id) {
        return productRepository.findById(id).map(ProductMapper::productEntityToProductDTO);
    }

}
