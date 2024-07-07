package com.backend.backend.service;
import java.util.List;

import com.backend.backend.dto.ProductDto;

public interface ProductService {
    
    ProductDto createProduct(ProductDto product);

    // page number is in the url
    // page size which mean how many item idsplay in one page
    
    List<ProductDto> getAllProducts(int pageNo, int pageSize);

    ProductDto getProductById(Long id);

    ProductDto updateProduct(Long id, ProductDto newProduct);

    void deleteProduct(Long id);

}
