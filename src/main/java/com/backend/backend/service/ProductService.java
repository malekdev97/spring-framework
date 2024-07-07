package com.backend.backend.service;
import java.util.List;

import com.backend.backend.dto.ProductDto;

public interface ProductService {
    
    ProductDto createProduct(ProductDto product);

    List<ProductDto> getAllProducts();

    ProductDto getProductById(Long id);

    ProductDto updateProduct(Long id, ProductDto newProduct);

    void deleteProduct(Long id);

}
