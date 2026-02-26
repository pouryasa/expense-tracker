package com.financial.expensetracker.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class AccountRequest {

    @NotNull(message = "{account.name.is.empty}")
    @NotBlank(message = "{account.name.is.empty}")
    private String name;

    @NotBlank(message = "{account.type.is.empty}")
    private String type;

    @NotNull(message = "{account.balance.is.empty}")
    private BigDecimal balance;
}
