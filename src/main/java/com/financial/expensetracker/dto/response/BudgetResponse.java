package com.financial.expensetracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
public class BudgetResponse {
    public final Long budgetId;
    public final String name;
    public final BigDecimal amountLimit;
    public final LocalDate startDate;
    public final LocalDate endDate;


}
