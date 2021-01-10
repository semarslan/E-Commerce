package com.semarslan.ecommerce.product.service;

import com.semarslan.ecommerce.product.entity.MoneyType;
import com.semarslan.ecommerce.product.repository.mongo.ProductPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductPriceService {

    private final ProductPriceRepository productPriceRepository;

    public BigDecimal getByMoneyType(String id, MoneyType usd) {
        return BigDecimal.TEN;
    }
}
