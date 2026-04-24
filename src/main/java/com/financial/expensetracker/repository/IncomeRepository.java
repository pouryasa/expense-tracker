package com.financial.expensetracker.repository;

import com.financial.expensetracker.model.Expense;
import com.financial.expensetracker.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
    Optional<Income> findByTitle(String name);
}
