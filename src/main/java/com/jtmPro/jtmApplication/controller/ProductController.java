package com.jtmPro.jtmApplication.controller;

import com.jtmPro.jtmApplication.dto.ProductRequest;
import com.jtmPro.jtmApplication.dto.ProductResponse;
import com.jtmPro.jtmApplication.repository.ProductRepository;
import com.jtmPro.jtmApplication.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String id) {
        Optional<ProductResponse> productResponse = productService.getProductId(id);
        return productResponse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable String id,
            @RequestBody ProductRequest productRequest) {
        if (id == null || id.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        return productService.updateProduct(id, productRequest)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public Optional<ResponseEntity<Object>> deleteProduct(@PathVariable String id) {
        if (id == null || id.isEmpty()) {
            return Optional.of(ResponseEntity.badRequest().build());
        }

        return productService.deleteProduct(id)
                .map(deleted -> ResponseEntity.noContent().build()) ;

    }



}
