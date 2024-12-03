package com.example.supplierService.service;

import com.example.supplierService.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO saveSupplier(SupplierDTO supplierDTO);
    SupplierDTO updateSupplier(SupplierDTO supplierDTO);
    SupplierDTO serachSupplier(long id);
    void deleteSupplier(long id);
    List<SupplierDTO> getAllSuppliers();

}
