package com.financial.expensetracker.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter

public class UserRequest {
    @NotNull(message = "{username.is.empty}")
    @NotBlank(message = "{currency.is.empty}")
    private String username;
    @NotNull(message = "{email.is.empty}")
    @NotBlank(message = "{currency.is.empty}")
    private String email;
    @NotNull(message = "{password.is.empty}")
    @NotBlank(message = "{currency.is.empty}")
    private String password;
    @NotNull(message = "{currency.is.empty}")
    @NotBlank(message = "{currency.is.empty}")
    private String currency;
}
