package com.financial.expensetracker.dto.request;

import lombok.Getter;

@Getter
public class UserRequest {
    private String username;
    private String email;
    private String password;
    private String currency;
}
