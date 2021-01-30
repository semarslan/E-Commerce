package com.semarslan.ecommerce.product.entity.es;

import com.semarslan.ecommerce.product.entity.MoneyTypes;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;
import java.util.HashMap;

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
    private HashMap<MoneyTypes,BigDecimal> price;
    private CategoryEs category;
    private Boolean active;

}
