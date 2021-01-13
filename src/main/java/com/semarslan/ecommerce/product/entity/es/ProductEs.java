package com.semarslan.ecommerce.product.entity.es;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

@Document(indexName = "product")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
public class ProductEs {

    private String id;
    private String name;
    private String code;
    private String description;
    private CompanyEs seller;
    private String feature;
    private BigDecimal price;
    private CategoryEs category;
    private Boolean active;

}
