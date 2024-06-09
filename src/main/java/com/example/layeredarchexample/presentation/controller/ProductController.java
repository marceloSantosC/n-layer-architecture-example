package com.example.layeredarchexample.presentation.controller;


import com.example.layeredarchexample.application.service.ProductService;
import com.example.layeredarchexample.presentation.dto.NewProductDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
