package com.example.listviewsecondassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val expensesList = findViewById<ListView>(R.id.lvExpense)
        val expenseTotal:TextView=findViewById(R.id.tvTotalExpenses)
        val expenses = arrayOf(Expense("Groceries",5000.00),
                               Expense("Transportation",8000.00),
                               Expense("Rent",50000.00),
            Expense("Cell Phone",800.00),
                                Expense("Utility Bills",6500.00),
        Expense("Insurance",5000.00)
        )

        val expenseAdapter = ExpenseAdapter(expenses)

        expensesList.adapter=expenseAdapter

        var total=0.0
        expenses.forEach {
            total += it.itemPrice
        }
        expenseTotal.text= "₹$total"

    }
}