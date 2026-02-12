package com.financial.expensetracker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue
    private Long categoryId;

    private String name;
    private String type;

    @OneToMany(
            mappedBy = "category"
    )
    private List<Budget> budgets;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(
            mappedBy = "category",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Income> incomes;

    @OneToMany(
            mappedBy = "category"
    )
    private List<Expense> expenses;
}
