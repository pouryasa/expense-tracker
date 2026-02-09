package com.financial.expensetracker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class PaymentMethod {
    @Id
    @GeneratedValue
    private Long PaymentMethodId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(
            mappedBy = "paymentMethod"
    )
    private List<Expense> expenses;
}
