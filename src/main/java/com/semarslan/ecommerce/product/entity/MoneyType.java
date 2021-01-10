package com.semarslan.ecommerce.product.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MoneyType {
    USD("Dolar", "$"),
    EUR("Euro", "E"),
    TL("Türk Lirası", "T");

    private String label;
    private String symbol;

}
