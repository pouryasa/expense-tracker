package com.financial.expensetracker.service;

import com.financial.expensetracker.dto.request.BudgetRequest;
import com.financial.expensetracker.dto.response.BudgetResponse;
import com.financial.expensetracker.repository.BudgetRepository;
import org.springframework.stereotype.Service;

@Service
public interface BudgetService {
    BudgetResponse save(BudgetRequest budgetRequest);
}
