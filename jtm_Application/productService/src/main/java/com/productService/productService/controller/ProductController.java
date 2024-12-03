package com.productService.productService.controller;
import com.productService.productService.dto.ProductDTO;
import com.productService.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/supplier")
public class ProductController {
    @Autowired
    private ProductService productService;

    // Save Supplier
    @PostMapping
    public ResponseEntity<ProductDTO> saveSupplier(@RequestBody ProductDTO supplierDTO) {
        return ResponseEntity.ok(productService.saveProduct(supplierDTO));
    }

    // Update Supplier
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateSupplier(@PathVariable Long id, @RequestBody ProductDTO supplierDTO) {
        if (supplierDTO == null) {
            return ResponseEntity.badRequest().body(null);
        }
        supplierDTO.setId(id);
        productService.updateProduct(supplierDTO);
        return ResponseEntity.ok().build();

    }

    // Get a Supplier by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getSupplier(@PathVariable Long id) {
        ProductDTO supplier = productService.serachProduct(id);
        return ResponseEntity.ok(supplier);
    }

    // Delete a Supplier
    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable Long id) {
        productService.deleteProduct(id);

    }

    // Get All Suppliers
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllSuppliers() {
        List<ProductDTO> suppliers = productService.getAllProduct();
        return ResponseEntity.ok(suppliers);
    }
}
