package com.semarslan.ecommerce.product.model;

import com.semarslan.ecommerce.product.entity.MoneyType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductResponse {

    private String id;
    private String image;
    private String name;
    private String description;
    private ProductSellerResponse seller;
    private String features;
    private int available;
    private boolean freeDelivery;
    private String deliveryIn;
    private BigDecimal price;
    private String categoryId;
    private MoneyType moneyType;
}
