package com.financial.expensetracker.service;

import com.financial.expensetracker.dto.request.IncomeRequest;
import com.financial.expensetracker.dto.response.IncomeResponse;
import com.financial.expensetracker.exception.RuleException;
import com.financial.expensetracker.model.Income;
import com.financial.expensetracker.repository.IncomeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IncomeServiceImp implements IncomeService {
    private final IncomeRepository incomeRepository;

    public IncomeServiceImp(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    private Income createIncome(IncomeRequest incomeRequest){
        return Income.builder()
                .title(incomeRequest.getTitle())
                .amount(incomeRequest.getAmount())
                .description(incomeRequest.getDescription())
                .incomeDate(incomeRequest.getIncomeDate())
                .build();
    }

    @Override
    public IncomeResponse save(IncomeRequest incomeRequest){
        Optional<Income> thisTitle = incomeRepository.findByTitle(incomeRequest.getTitle());

        if (thisTitle.isPresent()) {
            throw new RuleException("income.title.selected.before");
        }

        Income savedIncome = incomeRepository.save(createIncome(incomeRequest));
        return createIncomeResponse(savedIncome);
    }

    private IncomeResponse createIncomeResponse(Income thisIncome){
        return IncomeResponse.builder()
                .incomeId(thisIncome.getIncomeId())
                .title(thisIncome.getTitle())
                .amount(thisIncome.getAmount())
                .incomeDate(thisIncome.getIncomeDate())
                .description(thisIncome.getDescription())
                .build();
    }
}
