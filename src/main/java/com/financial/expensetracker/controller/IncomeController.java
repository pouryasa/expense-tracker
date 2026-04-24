package com.financial.expensetracker.controller;

import com.financial.expensetracker.dto.request.IncomeRequest;
import com.financial.expensetracker.dto.response.IncomeResponse;
import com.financial.expensetracker.repository.IncomeRepository;
import com.financial.expensetracker.service.IncomeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/income")
public class IncomeController {
    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @PostMapping("/new-income")
    public ResponseEntity<IncomeResponse> save(@RequestBody @Valid IncomeRequest incomeRequest) {
        return ResponseEntity.ok(incomeService.save(incomeRequest));
    }
}
