package com.productService.productService.service;

import com.productService.productService.dto.ProductDTO;

import java.util.List;

public interface ProductService {
ProductDTO saveProduct(ProductDTO productDTO);
    ProductDTO updateProduct(ProductDTO productDTO);
    ProductDTO serachProduct(long id);
    void deleteProduct(long id);
    List<ProductDTO> getAllProduct();

}
