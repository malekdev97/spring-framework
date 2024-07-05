package com.backend.backend.service;

import java.util.List;
<<<<<<< HEAD
import java.util.stream.Collectors;
=======

>>>>>>> 6e64836 (edit servic)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.backend.dto.ProductDto;
import com.backend.backend.model.Product;
import com.backend.backend.repository.ProductRepository;

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

<<<<<<< HEAD

    public List<ProductDto> findAll() {
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

    
    private Product mapToEntity(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setType(productDto.getType());

        return product;
    }

    
=======
    @Override 
    public List<ProductDto> getAllProducts() {

        return null;
    }
>>>>>>> 6e64836 (edit servic)
    
}
