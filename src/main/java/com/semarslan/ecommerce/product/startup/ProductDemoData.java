package com.semarslan.ecommerce.product.startup;

import com.semarslan.ecommerce.product.entity.MoneyType;
import com.semarslan.ecommerce.product.model.ProductSaveRequest;
import com.semarslan.ecommerce.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class ProductDemoData {
    private final ProductService productService;


    @EventListener(ApplicationReadyEvent.class)
    public void migrate() {
        Long countOfData = productService.count().block();
        if (countOfData.equals(0L)) {
            IntStream.range(0, 20).forEach(item -> {
                productService.save(
                ProductSaveRequest.builder()
                        .sellerId(UUID.randomUUID().toString())
                        .id(UUID.randomUUID().toString())
                        .description("Product Description " + item)
                        .moneyType(MoneyType.USD)
                        .categoryId(UUID.randomUUID().toString())
                        .name("Product Name " + item)
                        .features("6 Plate, 6 Soup Bowl, 3 Platter, 6 Cups")
                        .price(BigDecimal.ONE)
                        .images(List.of("https://cdn.vuetifyjs.com/images/cards/cooking.png"))
                        .build());

            });
        }
    }
}
