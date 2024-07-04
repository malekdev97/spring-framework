package com.backend.backend.service;
import com.backend.backend.dto.ProductDto;
import com.backend.backend.model.Product;

public interface ProductService {
    
    ProductDto createProduct(ProductDto product);
}
