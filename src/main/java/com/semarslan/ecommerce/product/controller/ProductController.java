package com.semarslan.ecommerce.product.controller;

import com.semarslan.ecommerce.product.model.product.ProductResponse;
import com.semarslan.ecommerce.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Flux<ProductResponse> getAllProducts() {
        return productService.getAll();
    }
}
