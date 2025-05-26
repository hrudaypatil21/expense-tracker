package com.hruday.expense_tracker.Service;

import com.hruday.expense_tracker.Model.Expense;
import com.hruday.expense_tracker.Model.User;
import com.hruday.expense_tracker.Repository.ExpenseRepository;
import com.hruday.expense_tracker.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository,
                          UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Expense createExpense(Long id, Expense expense) {
        if(userRepository.findById(id).isEmpty()){
            throw new RuntimeException("User not found with id: " + id);
        }
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

    public List<Expense> getExpensesByDates(LocalDate startingDate, LocalDate endingDate) {
        return expenseRepository.findByExpenseDateBetween(startingDate, endingDate);
    }

    public List<Expense> searchExpenses(String query) {
        return expenseRepository.searchExpenses(query);
    }



}
