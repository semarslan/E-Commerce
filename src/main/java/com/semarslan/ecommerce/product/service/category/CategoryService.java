package com.semarslan.ecommerce.product.service.category;

import com.semarslan.ecommerce.product.entity.category.Category;
import com.semarslan.ecommerce.product.model.category.CategoryResponse;
import com.semarslan.ecommerce.product.model.category.CategorySaveRequest;
import com.semarslan.ecommerce.product.repository.mongo.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Flux<CategoryResponse> getAll() {
        return categoryRepository.findAll().map(this::mapToDto);
    }

    public Category getById(String id) {
        return categoryRepository.findById(id).block();
    }

    public CategoryResponse save(CategorySaveRequest request) {
        Category cat = Category.builder().code("K" + request.getName().charAt(0)).name(request.getName()).build();
        return mapToDto(categoryRepository.save(cat).block());
    }

    /**
     * Aldığı her category nesnesini categoryResponse
     * nesnesine dönüştürür.
     * @param category
     * @return
     */
    private CategoryResponse mapToDto(Category category) {
        if (category == null) {
            return null;
        }
        return CategoryResponse.builder().id(category.getId()).name(category.getName()).build();
    }
}
