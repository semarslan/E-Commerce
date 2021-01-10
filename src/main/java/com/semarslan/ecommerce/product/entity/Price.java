package com.semarslan.ecommerce.product.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "product_price")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Price {

    private String id;
    private String productId;
    private MoneyType moneyType;
    private String price;

}
