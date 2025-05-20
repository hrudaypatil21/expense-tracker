package com.hruday.expense_tracker.Repository;

import com.hruday.expense_tracker.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByPaymentTo(String paymentTo);
    List<Expense> findByDescription(String description);
    List<Expense> findByExpenseDate(LocalDateTime expenseDate);
}
