package com.financial.expensetracker.controller;

import com.financial.expensetracker.dto.request.AccountRequest;
import com.financial.expensetracker.dto.response.AccountResponse;
import com.financial.expensetracker.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/register")
    public ResponseEntity<AccountResponse> save(@RequestBody @Valid AccountRequest accountRequest) {
        return ResponseEntity.ok(accountService.save(accountRequest));
    }
}
