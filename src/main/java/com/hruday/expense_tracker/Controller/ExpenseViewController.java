package com.hruday.expense_tracker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/expenses")
public class ExpenseViewController {

    @GetMapping("/new")
    public String newExpenseForm() {
        return "expenses/new";
    }
}
