package com.semarslan.ecommerce.product.model.product;

import com.semarslan.ecommerce.product.entity.MoneyType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Builder
@Data
public class ProductSaveRequest {

    private String id;
    private String name;
    private String description;
    private String features;
    private BigDecimal available;
    private BigDecimal price;
    private MoneyType moneyType;
    private List<String> images;
    private String sellerId;
    private String categoryId;
}
