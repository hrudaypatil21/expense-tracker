package com.hruday.expense_tracker.Repository;

import com.hruday.expense_tracker.Model.Expense;
import com.hruday.expense_tracker.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByPaymentTo(String paymentTo);
    List<Expense> findByDescription(String description);
    List<Expense> findByExpenseDate(LocalDate expenseDate);
    List<Expense> findByExpenseDateBetween(LocalDate startingDate, LocalDate endingDate);

    @Query(nativeQuery = true, value = "SELECT * FROM expense WHERE payment_to LIKE %:query% OR description LIKE %:query%")
    List<Expense> searchExpenses(String query);

    List<Expense> findByUser(User user);
    List<Expense> findByUserAndPaymentTo(User user, String paymentTo);
}
