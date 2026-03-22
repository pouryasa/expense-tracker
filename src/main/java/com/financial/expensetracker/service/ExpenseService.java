package com.financial.expensetracker.service;

import com.financial.expensetracker.dto.request.ExpenseRequest;
import com.financial.expensetracker.dto.response.ExpenseResponse;
import org.springframework.stereotype.Service;

@Service
public interface ExpenseService {
    ExpenseResponse save(ExpenseRequest expenseRequest);
}
