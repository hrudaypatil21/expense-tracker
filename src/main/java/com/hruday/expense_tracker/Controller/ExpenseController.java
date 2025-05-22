package com.hruday.expense_tracker.Controller;

import com.hruday.expense_tracker.Model.Expense;
import com.hruday.expense_tracker.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;


    @PostMapping("/create")
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
        Expense createdExpense = expenseService.createExpense(expense);
        return new ResponseEntity<>(createdExpense, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Expense>> getAllExpenses() {
        List<Expense> expenses = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable("id") Long id) {
        Expense expense = expenseService.getExpenseById(id);
        return ResponseEntity.ok(expense);
    }

    @GetMapping("/search/paymentTo/{paymentTo}")
    public ResponseEntity<List<Expense>> getExpensesByPaymentTo(@PathVariable ("paymentTo") String paymentTo) {
        List<Expense> expenses = expenseService.getExpensesByPaymentTo(paymentTo);
        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/search/description/{description}")
    public ResponseEntity<List<Expense>> getExpensesByDescription(@PathVariable ("description") String description) {
        List<Expense> expenses = expenseService.getExpensesByDescription(description);
        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/search/expenseDate")
    public ResponseEntity<List<Expense>> getExpensesByDates(
            @RequestParam("startingDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startingDate,
            @RequestParam("endingDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endingDate) {

        List<Expense> expenses = expenseService.getExpensesByDates(startingDate, endingDate);
        return ResponseEntity.ok(expenses);
    }

}
