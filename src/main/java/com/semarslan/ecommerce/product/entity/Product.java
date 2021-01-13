package com.semarslan.ecommerce.product.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document(collection = "product")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
public class Product {

    @Id
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
