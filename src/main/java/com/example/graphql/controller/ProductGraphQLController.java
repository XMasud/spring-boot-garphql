package com.example.graphql.controller;

import com.example.graphql.dto.ProductDto;
import com.example.graphql.service.ProductService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductGraphQLController {

    private final ProductService productService;

    public ProductGraphQLController(ProductService productService) {
        this.productService = productService;
    }

    @QueryMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @QueryMapping
    public ProductDto getProductById(@Argument Long id) {
        return productService.getProductById(id);
    }

    @MutationMapping
    public void deleteProductById(@Argument Long id) {
        productService.deleteProductById(id);
    }

    @MutationMapping
    public ProductDto createProduct(@Argument String name, @Argument String description, @Argument Float price, @Argument int stock) {
        ProductDto productDto = new ProductDto(null, name, description, price, stock );
        return productService.createProduct(productDto);
    }
}
