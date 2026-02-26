package com.financial.expensetracker.service;

import com.financial.expensetracker.dto.request.AccountRequest;
import com.financial.expensetracker.dto.response.AccountResponse;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    AccountResponse save(AccountRequest accountRequest);
}
