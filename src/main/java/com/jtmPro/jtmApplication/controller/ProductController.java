package com.jtmPro.jtmApplication.controller;

import com.jtmPro.jtmApplication.dto.ProductRequest;
import com.jtmPro.jtmApplication.dto.ProductResponse;
import com.jtmPro.jtmApplication.model.Product;
import com.jtmPro.jtmApplication.repository.ProductRepository;
import com.jtmPro.jtmApplication.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
productService.createProduct(productRequest);


    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProduct(){
      return productService.getAllProduct();
    }

}
