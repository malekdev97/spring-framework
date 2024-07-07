package com.backend.backend.service;

import com.backend.backend.dto.ProductDto;
import com.backend.backend.dto.ProductResponse;

public interface ProductService {
    
    ProductDto createProduct(ProductDto product);

    // page number is in the url
    // page size which mean how many item idsplay in one page

    ProductResponse getAllProducts(int pageNo, int pageSize);

    ProductDto getProductById(Long id);

    ProductDto updateProduct(Long id, ProductDto newProduct);

    void deleteProduct(Long id);

}
