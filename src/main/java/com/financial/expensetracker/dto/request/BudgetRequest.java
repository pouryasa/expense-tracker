package com.financial.expensetracker.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class BudgetRequest {

    @NotBlank(message = "{budget.name.is.empty}")
    @NotNull(message = "{budget.name.is.empty}")
    private String name;

    @NotNull(message = "{budget.amountLimit.is.empty}")
    private BigDecimal amountLimit;

    @NotNull(message = "{budget.start.time.not.selected}")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate startDate;

    @NotNull(message = "{budget.end.time.not.selected}")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate endDate;
}
