package com.semarslan.ecommerce.product.entity;

public class ProductImage {

    private ImageType imageType;
    private String url;


    enum ImageType {
        FEATURE, NORMAL;
    }
}
