package com.financial.expensetracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class PaymentMethodResponse {
    public final Long paymentMethodId;
    public final String method;
}
