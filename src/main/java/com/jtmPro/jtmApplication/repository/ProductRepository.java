package com.jtmPro.jtmApplication.repository;

import com.jtmPro.jtmApplication.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
