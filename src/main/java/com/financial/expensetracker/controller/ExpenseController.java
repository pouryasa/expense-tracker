package com.financial.expensetracker.controller;

import com.financial.expensetracker.dto.request.ExpenseRequest;
import com.financial.expensetracker.dto.response.ExpenseResponse;
import com.financial.expensetracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("/new-expense")
    public ResponseEntity<ExpenseResponse> save(@RequestBody @Valid ExpenseRequest expenseRequest) {
        return ResponseEntity.ok(expenseService.save(expenseRequest));
    }
}
