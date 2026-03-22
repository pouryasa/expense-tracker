package com.financial.expensetracker.service;

import com.financial.expensetracker.dto.request.ExpenseRequest;
import com.financial.expensetracker.dto.response.ExpenseResponse;
import com.financial.expensetracker.exception.RuleException;
import com.financial.expensetracker.model.Expense;
import com.financial.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpenseServiceImp implements ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImp(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    private Expense createExpense(ExpenseRequest expenseRequest) {
        return Expense.builder()
                .title(expenseRequest.getTitle())
                .amount(expenseRequest.getAmount())
                .description((expenseRequest.getDescription()))
                .description(expenseRequest.getDescription())
                .expenseDate(expenseRequest.getExpenseDate())
                .build();
    }

    @Override
    public ExpenseResponse save(ExpenseRequest expenseRequest) {
        Optional<Expense> thisTitle = expenseRepository.findByTitle(expenseRequest.getTitle());

        if (thisTitle.isPresent()) {
            throw new RuleException("expense.title.selected.before");
        }

        Expense savedExpense = expenseRepository.save(createExpense(expenseRequest));
        return createExpenseResponse(savedExpense);
    }

    private ExpenseResponse createExpenseResponse(Expense thisExpense) {
        return ExpenseResponse.builder()
                .expenseId(thisExpense.getExpenseId())
                .title(thisExpense.getTitle())
                .amount(thisExpense.getAmount())
                .expenseDate(thisExpense.getExpenseDate())
                .description(thisExpense.getDescription())
                .build();
    }
}
