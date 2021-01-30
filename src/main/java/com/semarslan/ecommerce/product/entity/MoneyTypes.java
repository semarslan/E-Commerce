package com.semarslan.ecommerce.product.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MoneyTypes {
    USD("Dolar", "$"),
    EUR("Euro", "E"),
    TL("Türk Lirası", "T");

    private String label;
    private String symbol;



    public String getSymbol() {
        return symbol;
    }
}
