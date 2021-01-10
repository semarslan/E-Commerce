package com.semarslan.ecommerce.product.repository.mongo;

import com.semarslan.ecommerce.product.entity.Price;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductPriceRepository extends ReactiveMongoRepository<Price, String> {
}
