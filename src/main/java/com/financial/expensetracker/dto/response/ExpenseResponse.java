package com.financial.expensetracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Builder
public class ExpenseResponse {
    public final Long expenseId;
    public final String title;
    public final BigDecimal amount;
    public final String description;
    public final LocalDate expenseDate;
}
