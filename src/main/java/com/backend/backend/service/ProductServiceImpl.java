package com.backend.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.backend.dto.ProductDto;
import com.backend.backend.exception.ProductNotFoundException;
import com.backend.backend.model.Product;
import com.backend.backend.repository.ProductRepository;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    
    // we wrap the dependency injection in a constructor, so when we wanna test this class we can easily mock the dependency
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setType(productDto.getType());

        Product newProduct = productRepository.save(product);

        ProductDto productResponse = new ProductDto();
        productResponse.setId(newProduct.getId());
        productResponse.setName(newProduct.getName());
        productResponse.setType(newProduct.getType());

        return productResponse;
    }

    @Override 
    public List<ProductDto> getAllProducts() {
        Product p1 = productRepository.findById(99l).orElseThrow(() -> new ProductNotFoundException("Product not found!"));

        List<Product> products = productRepository.findAll();

        return products.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        
    }

    private ProductDto mapToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setType(product.getType());

        return productDto;
    }

    private Product mapToEntity(ProductDto pDto) {
        Product p = new Product();
        p.setName(pDto.getName());
        p.setType(pDto.getType());

        return p;
    }
    
}
