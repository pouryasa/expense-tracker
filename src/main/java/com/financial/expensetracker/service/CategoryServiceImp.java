package com.financial.expensetracker.service;

import com.financial.expensetracker.dto.request.CategoryRequest;
import com.financial.expensetracker.dto.response.CategoryResponse;
import com.financial.expensetracker.exception.RuleException;
import com.financial.expensetracker.model.Category;
import com.financial.expensetracker.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    private Category creatCategory(CategoryRequest categoryRequest) {
        return Category.builder()
                .name(categoryRequest.getName())
                .type(categoryRequest.getType())
                .build();
    }

    @Override
    public CategoryResponse save(CategoryRequest categoryRequest) {
        Optional<Category> thisName = categoryRepository.findByName(categoryRequest.getName());

        if (thisName.isPresent()) {
            throw new RuleException("category.is.exist");
        } else {
            return createCategoryResponse(categoryRepository.save(creatCategory(categoryRequest)));
        }
    }

    private CategoryResponse createCategoryResponse(Category thisCategory) {
        return CategoryResponse.builder()
                .categoryId(thisCategory.getCategoryId())
                .name(thisCategory.getName())
                .type(thisCategory.getType())
                .build();
    }
}
