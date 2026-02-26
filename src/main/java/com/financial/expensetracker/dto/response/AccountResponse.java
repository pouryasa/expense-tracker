package com.financial.expensetracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@Builder
public class AccountResponse {
    public final Long accountId;
    public final String name;
    public final BigDecimal balance;
    public final String type;


}
