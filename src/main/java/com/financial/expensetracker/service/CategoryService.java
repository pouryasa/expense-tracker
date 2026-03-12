package com.financial.expensetracker.service;

import com.financial.expensetracker.dto.request.CategoryRequest;
import com.financial.expensetracker.dto.response.CategoryResponse;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    CategoryResponse save(CategoryRequest categoryRequest);
}
