package com.financial.expensetracker.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PaymentMethodRequest {
    @NotNull(message = "please.enter.payment.method")
    @NotBlank(message = "please.enter.payment.method")
    private String method;
}
