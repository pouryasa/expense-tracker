package com.financial.expensetracker.service;

import com.financial.expensetracker.dto.request.BudgetRequest;
import com.financial.expensetracker.dto.response.BudgetResponse;
import com.financial.expensetracker.exception.RuleException;
import com.financial.expensetracker.model.Budget;
import com.financial.expensetracker.repository.BudgetRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BudgetServiceImp implements BudgetService {

    final BudgetRepository budgetRepository;

    public BudgetServiceImp(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    private Budget createBudget(BudgetRequest budgetRequest) {
        return Budget.builder()
                .name(budgetRequest.getName())
                .amountLimit(budgetRequest.getAmountLimit())
                .startDate(budgetRequest.getStartDate())
                .endDate(budgetRequest.getEndDate())
                .build();
    }

    private void validateDates(@NotNull(message = "{budget.start.time.not.selected}")
                                       LocalDate startDate,
                               @NotNull(message = "{budget.end.time.not.selected}")
                                       LocalDate endDate) {

        if (startDate.isAfter(endDate)) {
            throw new RuleException("budget.startDate.after.endDate");
        }
    }

    @Override
    public BudgetResponse save(BudgetRequest budgetRequest) {


        validateDates(budgetRequest.getStartDate(), budgetRequest.getEndDate());

        Optional<Budget> thisName = budgetRepository.findByName(budgetRequest.getName());
        if (thisName.isPresent()) {
            throw new RuleException("budget.name.selected.before");
        }

        Budget savedBudget = budgetRepository.save(createBudget(budgetRequest));
        return createBudgetResponse(savedBudget);
    }

    private BudgetResponse createBudgetResponse(Budget thisBudget) {
        return BudgetResponse.builder()
                .budgetId(thisBudget.getBudgetId())
                .name(thisBudget.getName())
                .amountLimit(thisBudget.getAmountLimit())
                .startDate(thisBudget.getStartDate())
                .endDate(thisBudget.getEndDate())
                .build();
    }
}