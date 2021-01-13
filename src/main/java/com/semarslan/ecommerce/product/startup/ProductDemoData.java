package com.semarslan.ecommerce.product.startup;

import com.semarslan.ecommerce.product.entity.MoneyType;
import com.semarslan.ecommerce.product.model.category.CategoryResponse;
import com.semarslan.ecommerce.product.model.category.CategorySaveRequest;
import com.semarslan.ecommerce.product.model.product.ProductSaveRequest;
import com.semarslan.ecommerce.product.service.ProductService;
import com.semarslan.ecommerce.product.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
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
    private final CategoryService categoryService;

    @EventListener(ApplicationReadyEvent.class)
    public void migrate() {
        Long countOfData = productService.count().block();
        if (countOfData.equals(0L)) {

            CategoryResponse categoryKitchen =  categoryService.save(CategorySaveRequest.builder().name("Kitchen").build());
            CategoryResponse categoryPhone =  categoryService.save(CategorySaveRequest.builder().name("Mobile phone").build());

            IntStream.range(0, 20).forEach(item -> {
                productService.save(
                ProductSaveRequest.builder()
                        .sellerId(UUID.randomUUID().toString())
                        .id(UUID.randomUUID().toString())
                        .description("Product Description " + item)
                        .moneyType(MoneyType.USD)
                        .categoryId(categoryKitchen.getId())
                        .name("Product Name " + item)
                        .features("6 Plate, 6 Soup Bowl, 3 Platter, 6 Cups")
                        .price(BigDecimal.ONE)
                        .images(List.of("https://cdn.vuetifyjs.com/images/cards/cooking.png"))
                        .build());

            });
        }
    }
}
