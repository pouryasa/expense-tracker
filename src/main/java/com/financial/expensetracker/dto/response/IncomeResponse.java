package com.financial.expensetracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Builder
public class IncomeResponse {
    public final Long incomeId;
    public final String title;
    public final BigDecimal amount;
    public final String description;
    public final LocalDate incomeDate;
}
