package com.productService.productService.service.impl;

import com.productService.productService.dto.ProductDTO;
import com.productService.productService.entity.Product;
import com.productService.productService.repository.ProductRepository;
import com.productService.productService.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
       productRepository.save( modelMapper.map(productDTO, Product.class));

        return productDTO;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO ){
       productRepository.save( modelMapper.map(productDTO, Product.class));

        return productDTO;
    }

    @Override
    public ProductDTO serachProduct(long id) {
        Product supplier = productRepository.findById(id).orElse(null);
        if (supplier != null) {
            return modelMapper.map(supplier, ProductDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDTO> getAllProduct() {
        List<Product> suppliers = productRepository.findAll();
        return modelMapper.map(suppliers, new TypeToken<List<ProductDTO>>() {}.getType());
    }
}
