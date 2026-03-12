package com.financial.expensetracker.controller;

import com.financial.expensetracker.dto.request.BudgetRequest;
import com.financial.expensetracker.dto.response.BudgetResponse;
import com.financial.expensetracker.service.BudgetService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/budget")
public class BudgetController {

    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PostMapping("/new-budget")
    public ResponseEntity<BudgetResponse> save(@RequestBody @Valid BudgetRequest budgetRequest) {
        return ResponseEntity.ok(budgetService.save(budgetRequest));
    }
}
