package com.semarslan.ecommerce.product.service;

import org.springframework.stereotype.Service;

@Service
public class ProductImageService {


    public String getProductMainImage(String productId) {
        return "https://cdn.vuetifyjs.com/images/cards/cooking.png";
    }
}
