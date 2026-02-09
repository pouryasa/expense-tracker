package com.financial.expensetracker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    Integer userId;

    private String name;
    private String email;
    private String password_hash;
    private String currency;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Account> accounts;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Category> categories;

}
