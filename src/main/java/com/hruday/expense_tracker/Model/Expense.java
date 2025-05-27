package com.hruday.expense_tracker.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
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

    @Enumerated
    @Column(name="expense_type", nullable = false)
    private ExpenseType expenseType;

    @Column(name="expense_date", nullable = false)
    private LocalDate expenseDate;

    @Column(name="description")
    private String description;

    public enum ExpenseType {
        DEPOSIT("Deposit"),
        WITHDRAWAL("Withdrawal");

        private final String displayName;

        ExpenseType(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String toString() {
            return displayName;
        }
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
