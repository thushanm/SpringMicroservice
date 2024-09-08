package com.productService.productService.service;

import com.productService.productService.dto.ProductRequest;
import com.productService.productService.dto.ProductResponse;
import com.productService.productService.model.Product;
import com.productService.productService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest){
        Product product =Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
log.info("product {} is saved",product.getId());

    }
    public List<ProductResponse> getAllProduct(){
        List<Product> all = productRepository.findAll();
        return all.stream().map(this::mapToProductResponse).toList();

    }
    public Optional<ProductResponse> getProductId(String id){
        Product product=productRepository.findById(id).orElse(null);
        return  Optional.ofNullable(product).map(this::mapToProductResponse);

    }
public Optional<ProductResponse> updateProduct(String id, ProductRequest productRequest){
return productRepository.findById(id)
        .map(product -> {
            product.setName(productRequest.getName());
            product.setDescription(productRequest.getDescription());
            product.setPrice(productRequest.getPrice());
            productRepository.save(product);
            return mapToProductResponse(product);
        });

}
    public Optional<Void> deleteProduct(String id) {
        return productRepository.findById(id)
                .map(product -> {
                    productRepository.delete(product);
                    return null;  // Return null because there's no response body for a DELETE operation
                });
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
