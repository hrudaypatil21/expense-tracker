package com.hruday.expense_tracker.Repository;

import com.hruday.expense_tracker.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByPaymentTo(String paymentTo);
    List<Expense> findByDescription(String description);
    List<Expense> findByExpenseDate(LocalDateTime expenseDate);
    List<Expense> findByExpenseDateBetween(LocalDateTime startingDate, LocalDateTime endingDate);

    @Query(nativeQuery = true, value = "SELECT * FROM expense WHERE payment_to LIKE %:query% OR description LIKE %:query%")
    List<Expense> searchExpenses(String query);
}
