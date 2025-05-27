package com.hruday.expense_tracker.Repository;

import com.hruday.expense_tracker.Model.Expense;
import com.hruday.expense_tracker.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    List<Expense> findByUserAndExpenseDateBetween(User user, LocalDate startingDate, LocalDate endingDate);
    List<Expense> findByUserAndDescription(User user, String description);

    @Query("SELECT e FROM Expense e WHERE e.user = :user AND " +
            "(LOWER(e.paymentTo) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
            "LOWER(e.description) LIKE LOWER(CONCAT('%', :query, '%')))")
    List<Expense> findByUserAndQuery(@Param("user") User user, @Param("query") String query);
}
