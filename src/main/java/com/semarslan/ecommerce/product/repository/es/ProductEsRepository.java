package com.semarslan.ecommerce.product.repository.es;

import com.semarslan.ecommerce.product.entity.es.ProductEs;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;

public interface ProductEsRepository extends ReactiveElasticsearchRepository<ProductEs, String> {
}
