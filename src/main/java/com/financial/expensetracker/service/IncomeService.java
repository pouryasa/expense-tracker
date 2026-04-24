package com.financial.expensetracker.service;

import com.financial.expensetracker.dto.request.IncomeRequest;
import com.financial.expensetracker.dto.response.IncomeResponse;
import org.springframework.stereotype.Service;

@Service
public interface IncomeService {
    IncomeResponse save(IncomeRequest incomeRequest);
}
