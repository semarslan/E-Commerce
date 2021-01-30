package com.semarslan.ecommerce.product.repository.mongo;

import com.semarslan.ecommerce.product.entity.category.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {
}
