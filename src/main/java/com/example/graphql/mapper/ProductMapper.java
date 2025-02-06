package com.example.graphql.mapper;

import com.example.graphql.dto.ProductDto;
import com.example.graphql.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductDto mapToProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock()
        );
    }

    public static Product mapToProduct(ProductDto productDto) {
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getStock()
        );
    }

    public static List<ProductDto> mapToProductDto(List<Product> products) {
        return products.stream()
                .map(ProductMapper::mapToProductDto)
                .collect(Collectors.toList());
    }
}
