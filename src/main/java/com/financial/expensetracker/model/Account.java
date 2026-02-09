package com.financial.expensetracker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue
    private Integer accountId;

    private String name;
    private String type;
    private BigDecimal balanced;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
