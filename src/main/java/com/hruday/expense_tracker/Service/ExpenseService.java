package com.hruday.expense_tracker.Service;

import com.hruday.expense_tracker.Model.Expense;
import com.hruday.expense_tracker.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Transactional
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public List<Expense> getExpensesByPaymentTo(String paymentTo) {
        return expenseRepository.findByPaymentTo(paymentTo);
    }

    public List<Expense> getExpensesByDescription(String description) {
        return expenseRepository.findByDescription(description);
    }

    public List<Expense> getExpensesByDates(LocalDateTime startingDate, LocalDateTime endingDate) {
        return expenseRepository.findByExpenseDateBetween(startingDate, endingDate);
    }




}
