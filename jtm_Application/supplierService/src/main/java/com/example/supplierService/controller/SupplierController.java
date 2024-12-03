package com.example.supplierService.controller;

import com.example.supplierService.dto.SupplierDTO;
import com.example.supplierService.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    // Save Supplier
    @PostMapping
    public ResponseEntity<SupplierDTO> saveSupplier(@RequestBody SupplierDTO supplierDTO) {
        return ResponseEntity.ok(supplierService.saveSupplier(supplierDTO));
    }

    // Update Supplier
    @PutMapping("/{id}")
    public ResponseEntity<SupplierDTO> updateSupplier(@PathVariable Long id, @RequestBody SupplierDTO supplierDTO) {
        if (supplierDTO == null) {
            return ResponseEntity.badRequest().body(null);
        }
        supplierDTO.setId(id);
        supplierService.updateSupplier(supplierDTO);
        return ResponseEntity.ok().build();

    }

    // Get a Supplier by ID
    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> getSupplier(@PathVariable Long id) {
        SupplierDTO supplier = supplierService.serachSupplier(id);
        return ResponseEntity.ok(supplier);
    }

    // Delete a Supplier
    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);

    }

    // Get All Suppliers
    @GetMapping
    public ResponseEntity<List<SupplierDTO>> getAllSuppliers() {
        List<SupplierDTO> suppliers = supplierService.getAllSuppliers();
        return ResponseEntity.ok(suppliers);
    }
}
