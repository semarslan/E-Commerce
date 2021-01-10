package com.semarslan.ecommerce.product.service;

import com.semarslan.ecommerce.product.entity.MoneyType;
import com.semarslan.ecommerce.product.entity.es.ProductEs;
import com.semarslan.ecommerce.product.model.ProductResponse;
import com.semarslan.ecommerce.product.model.ProductSaveRequest;
import com.semarslan.ecommerce.product.model.ProductSellerResponse;
import com.semarslan.ecommerce.product.repository.mongo.ProductRepository;
import com.semarslan.ecommerce.product.repository.es.ProductEsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductService {

    /**
     * productRepo'ya insert edilen herşeyi
     * elastic search'e update geçilecek.
     */
    private final ProductEsRepository productEsRepository;
    private final ProductRepository productRepository;
    private final ProductPriceService productPriceService;
    private final ProductDeliveryService productDeliveryService;
    private final ProductAmountService productAmountService;
    private final ProductImageService productImageService;


    public Flux<ProductResponse> getAll() {
        return productEsRepository.findAll().map(this::mapToDto);
    }


    ProductResponse save(ProductSaveRequest productSaveRequest) {
        return null;

    }

    /**
     * Calc fieldları işle
     * redisten ihtiyaç alanlarını getir
     * response nesnesine dönüştür
     *
     * @param productEs
     * @return
     */
    private ProductResponse mapToDto(ProductEs productEs) {
        BigDecimal productPrice = productPriceService.getByMoneyType(productEs.getId(), MoneyType.USD);
        return ProductResponse.builder()
                .price(productPrice)
                .name(productEs.getName())
                .features(productEs.getFeature())
                .id(productEs.getId())
                .description(productEs.getDescription())
                .deliveryIn(productDeliveryService.getDeliveryInfo(productEs.getId()))
                .categoryId(productEs.getCategory().getId())
                .available(productAmountService.getByProductId(productEs.getId()))
                .freeDelivery(productDeliveryService.freeDeliveryCheck(productEs.getId(), productPrice))
                .moneyType(MoneyType.USD)
                .image(productImageService.getProductMainImage(productEs.getId()))
                .seller(ProductSellerResponse.builder().id(productEs.getSeller().getId()).name(productEs.getSeller().getName()).build())
                .build();
    }
}
