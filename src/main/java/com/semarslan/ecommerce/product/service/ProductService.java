package com.semarslan.ecommerce.product.service;

import com.semarslan.ecommerce.product.entity.MoneyTypes;
import com.semarslan.ecommerce.product.entity.Product;
import com.semarslan.ecommerce.product.entity.ProductImage;
import com.semarslan.ecommerce.product.entity.es.ProductEs;
import com.semarslan.ecommerce.product.model.product.ProductResponse;
import com.semarslan.ecommerce.product.model.product.ProductSaveRequest;
import com.semarslan.ecommerce.product.model.ProductSellerResponse;
import com.semarslan.ecommerce.product.repository.mongo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    /**
     * productRepo'ya insert edilen herşeyi
     * elastic search'e update geçilecek.
     */
    private final ProductRepository productRepository;
    private final ProductDeliveryService productDeliveryService;
    private final ProductAmountService productAmountService;
    private final ProductImageService productImageService;
    private final ProductEsService productEsService;


    public Flux<ProductResponse> getAll() {
        return productEsService.findAll().map(this::mapToDto);
    }


    /**
     * mongo insert
     * es update
     * redis update
     * @param request
     * @return
     */
    public ProductResponse save(ProductSaveRequest request) {
        Product product = Product.builder()
                .active(Boolean.TRUE)
                .code("PR001")
                .categoryId(request.getCategoryId())
                .companyId(request.getSellerId())
                .description(request.getDescription())
                .feature(request.getFeatures())
                .name(request.getName())
                .price(request.getPrice())
                .productImage(request.getImages().stream()
                        .map(item -> new ProductImage(ProductImage.ImageType.FEATURE, item)).collect(Collectors.toList()))
                .build();

        product = productRepository.save(product).block();

        return this.mapToDto(productEsService.saveNewProduct(product).block());
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
        if (productEs == null) {
            return null;
        }

        return ProductResponse.builder()
                //TODO client üzerinden validate edilecek.
                .price(productEs.getPrice().get("USD"))
                .moneySymbol(MoneyTypes.USD.getSymbol())
                .name(productEs.getName())
                .features(productEs.getFeature())
                .id(productEs.getId())
                .description(productEs.getDescription())
                .deliveryIn(productDeliveryService.getDeliveryInfo(productEs.getId()))
                .categoryId(productEs.getCategory().getId())
                .available(productAmountService.getByProductId(productEs.getId()))
                .freeDelivery(productDeliveryService.freeDeliveryCheck(productEs.getId(), productEs.getPrice().get("USD"), MoneyTypes.USD))
                .image(productImageService.getProductMainImage(productEs.getId()))
                .seller(ProductSellerResponse.builder().id(productEs.getSeller().getId()).name(productEs.getSeller().getName()).build())
                .build();
    }

    public Mono<Long> count() {
        return productRepository.count();
    }
}
