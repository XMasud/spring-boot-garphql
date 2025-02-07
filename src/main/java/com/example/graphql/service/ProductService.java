package com.example.graphql.service;

import com.example.graphql.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    ProductDto getProductById(Long id);
    List<ProductDto> getAllProducts();
    void deleteProductById(Long id);
}
