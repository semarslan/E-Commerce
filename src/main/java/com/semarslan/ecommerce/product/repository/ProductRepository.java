package com.semarslan.ecommerce.product.repository;

import com.semarslan.ecommerce.product.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
