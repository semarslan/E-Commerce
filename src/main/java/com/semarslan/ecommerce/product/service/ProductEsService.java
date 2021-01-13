package com.semarslan.ecommerce.product.service;

import com.semarslan.ecommerce.product.entity.Product;
import com.semarslan.ecommerce.product.entity.category.Category;
import com.semarslan.ecommerce.product.entity.es.CategoryEs;
import com.semarslan.ecommerce.product.entity.es.CompanyEs;
import com.semarslan.ecommerce.product.entity.es.ProductEs;
import com.semarslan.ecommerce.product.repository.es.ProductEsRepository;
import com.semarslan.ecommerce.product.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class ProductEsService {

    private final ProductEsRepository productEsRepository;

    private final CategoryService categoryService;

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
                        .seller(CompanyEs.builder().id(product.getCompanyId()).name("Test").build())
                        .category(getProductCategory(product.getCategoryId()))
                        .build()
        );
    }

    private CategoryEs getProductCategory(String categoryId) {
        Category category = categoryService.getById(categoryId);
        return CategoryEs.builder().name(category.getName()).id(category.getId()).code(category.getCode()).build();
    }

    public Flux<ProductEs> findAll() {
        return productEsRepository.findAll();
    }
}
