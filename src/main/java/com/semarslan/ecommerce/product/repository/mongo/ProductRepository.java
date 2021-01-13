package com.semarslan.ecommerce.product.repository.mongo;

import com.semarslan.ecommerce.product.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}
