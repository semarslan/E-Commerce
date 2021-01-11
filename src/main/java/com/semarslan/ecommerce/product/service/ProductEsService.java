package com.semarslan.ecommerce.product.service;

import com.semarslan.ecommerce.product.entity.Product;
import com.semarslan.ecommerce.product.entity.es.CategoryEs;
import com.semarslan.ecommerce.product.entity.es.CompanyEs;
import com.semarslan.ecommerce.product.entity.es.ProductEs;
import com.semarslan.ecommerce.product.repository.es.ProductEsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class ProductEsService {

    private final ProductEsRepository productEsRepository;

    /**
     * Mongo ile es asenkron şekilde kayıt yapsın diye.
     */
    public Mono<ProductEs> saveNewProduct(Product product) {
        return productEsRepository.save(
                ProductEs.builder()
                        .active(product.getActive())
                        .code(product.getCode())
                        .description(product.getDescription())
                        .feature(product.getFeature())
                        .id(product.getId())
                        .name(product.getName())
                        // TODO get company name and code
                        .seller(CompanyEs.builder().id(product.getCompanyId()).name("").build())
                        // TODO get company name and code
                        .category(CategoryEs.builder().id(product.getCategoryId()).name("Test").build())
                        .build()
        );
    }

    public Flux<ProductEs> findAll() {
        return productEsRepository.findAll();
    }
}
