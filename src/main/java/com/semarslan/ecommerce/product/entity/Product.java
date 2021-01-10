package com.semarslan.ecommerce.product.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document(collation = "product")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Product {

    private String id;
    private String name;
    private String code;
    private Boolean active;
    private String description;
    private String companyId;
    private String feature;
    private BigDecimal price;
    private String categoryId;
    private List<ProductImage> productImage;


}
