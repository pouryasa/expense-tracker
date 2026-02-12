package com.financial.expensetracker.model;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Budget {
    @Id
    @GeneratedValue
    private Long budgetId;

    private BigDecimal amountLimit;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
