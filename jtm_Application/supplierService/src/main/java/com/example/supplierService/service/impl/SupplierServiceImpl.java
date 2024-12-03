package com.example.supplierService.service.impl;

import com.example.supplierService.dto.SupplierDTO;
import com.example.supplierService.entity.Supplier;
import com.example.supplierService.repository.SupplierRepository;
import com.example.supplierService.service.SupplierService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
        supplierRepository.save( modelMapper.map(supplierDTO, Supplier.class));

        return supplierDTO;
    }

    @Override
    public SupplierDTO updateSupplier(SupplierDTO supplierDTO) {
        supplierRepository.save( modelMapper.map(supplierDTO, Supplier.class));

        return supplierDTO;
    }

    @Override
    public SupplierDTO serachSupplier(long id) {
        Supplier supplier = supplierRepository.findById(id).orElse(null);
        if (supplier != null) {
            return modelMapper.map(supplier, SupplierDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public void deleteSupplier(long id) {
        supplierRepository.deleteById(id);
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return modelMapper.map(suppliers, new TypeToken<List<SupplierDTO>>() {}.getType());
    }
}
