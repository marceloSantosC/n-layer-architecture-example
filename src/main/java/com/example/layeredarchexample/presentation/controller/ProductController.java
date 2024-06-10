package com.example.layeredarchexample.presentation.controller;


import com.example.layeredarchexample.application.service.ProductService;
import com.example.layeredarchexample.presentation.dto.NewProductDTO;
import com.example.layeredarchexample.presentation.dto.ProductDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> registerProduct(@RequestBody NewProductDTO newProductDTO, HttpServletRequest request) {
        Long id = productService.registerProduct(newProductDTO);
        String uri = request.getRequestURL().append("/").append(id).toString();
        return ResponseEntity.created(URI.create(uri)).build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
        return productService.getProduct(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
