package com.backend.backend.service;
import java.util.List;

import com.backend.backend.dto.ProductDto;
import com.backend.backend.model.Product;

public interface ProductService {
    
    ProductDto createProduct(ProductDto product);

    List<ProductDto> getAllProducts();
}
