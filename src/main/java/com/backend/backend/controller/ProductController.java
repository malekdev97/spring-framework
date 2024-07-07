package com.backend.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.backend.backend.dto.ProductDto;
import com.backend.backend.model.Product;
import com.backend.backend.service.ProductService;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {


    private ProductService productService;
    
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.getAllProducts();

        // products.add(new Product(1, "Employee Manager", "ERP"));

        return ResponseEntity.ok(products);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        ProductDto product = productService.getProductById(id);

        return ResponseEntity.ok(product);
    }

    // @GetMapping("/products/{id}")
    // public Product findById(@PathVariable int id) {
    //     return new Product(id, "Employee Manager", "ERP");
    // } 

    @PostMapping("/products/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto product) {

        
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}/update")
    public ResponseEntity<ProductDto> update(@PathVariable Long id, @RequestBody ProductDto product) {
        
        ProductDto pDto = productService.updateProduct(id, product);
        
        return ResponseEntity.ok(pDto);
    }

    @DeleteMapping("/products/{id}/delete")
    public ResponseEntity<String> delete(@PathVariable int id) {

        return ResponseEntity.ok("Product deleted successfully!");
    }
}

