package com.financial.expensetracker.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class IncomeRequest {
    @NotBlank(message = "{income.title.is.empty}")
    @NotNull(message = "{income.title.is.empty}")
    private String title;

    @NotNull(message = "{income.amount.is.empty}")
    private BigDecimal amount;

    @NotNull(message = "{income.time.not.selected}")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate incomeDate;

    private String description;
}
