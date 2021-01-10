package com.semarslan.ecommerce.product.service;

import com.semarslan.ecommerce.product.model.ProductResponse;
import com.semarslan.ecommerce.product.model.ProductSaveRequest;
import com.semarslan.ecommerce.product.repository.ProductRepository;
import com.semarslan.ecommerce.product.repository.es.ProductEsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    /**
     * productRepo'ya insert edilen herşeyi
     * elastic search'e update geçilecek.
     */
    private final ProductEsRepository productEsRepository;
    private final ProductRepository productRepository;
    List<ProductResponse> getByPaging(Pageable pageable) {
        return null;
    }


    ProductResponse save(ProductSaveRequest productSaveRequest) {
        return null;

    }
}
