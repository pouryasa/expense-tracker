package com.financial.expensetracker.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class ExpenseRequest {

    @NotBlank(message = "{expense.title.is.empty}")
    @NotNull(message = "{expense.title.is.empty}")
    private String title;

    @NotNull(message = "{expense.amount.is.empty}")
    private BigDecimal amount;

    @NotNull(message = "{expense.time.not.selected}")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate expenseDate;

    private String description;
}
