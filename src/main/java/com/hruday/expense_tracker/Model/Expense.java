package com.hruday.expense_tracker.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="payment_to", nullable = false)
    private String paymentTo;

    @Column(name="payment_method")
    private String paymentMethod;

    @Column(name="amount", nullable = false)
    private Float amount;

    @Column(name="expense_date", nullable = false)
    private LocalDateTime expenseDate;

    @Column(name="description")
    private String description;

}
