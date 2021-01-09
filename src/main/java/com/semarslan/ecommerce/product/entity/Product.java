package com.semarslan.ecommerce.product.entity;

import org.springframework.data.annotation.Id;

public class Product {

    @Id
    private String id;

    private String name;

    private String productCode;

    private Boolean active;


}
