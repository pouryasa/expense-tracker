package com.financial.expensetracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Budget {
    @Id
    @GeneratedValue
    private Long budgetId;

    private String name;

    private BigDecimal amountLimit;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
