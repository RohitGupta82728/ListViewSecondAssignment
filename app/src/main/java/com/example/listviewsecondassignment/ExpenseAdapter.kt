package com.example.listviewsecondassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


class ExpenseAdapter(val expenses:Array<Expense>):BaseAdapter() {


    private class ViewHolder
    {
        lateinit var itemName:TextView
        lateinit var itemPrice:TextView
    }

    override fun getCount(): Int {
       return expenses.size
    }

    override fun getItem(position: Int): Expense {
        return expenses[position]
    }

    override fun getItemId(position: Int): Long {
        return expenses[position].itemName.hashCode().toLong()
    }

    override fun getView(position: Int, convertView: View?, container: ViewGroup?): View {
        val expenseView:View
        val viewHolder:ViewHolder
        if(convertView==null)
        {
            expenseView=LayoutInflater.from(container?.context).inflate(R.layout.expenses_list_items,container,false)
            viewHolder= ViewHolder()
            with(viewHolder){
                itemName=expenseView.findViewById(R.id.expenseItem)
                itemPrice=expenseView.findViewById(R.id.expensepPrice)
                expenseView.tag=viewHolder
            }
        }
        else
        {
            expenseView=convertView
            viewHolder=convertView.tag as ViewHolder
        }
        with(viewHolder) {
            val expense=getItem(position)
            itemName.text=expense.itemName
            itemPrice.text="₹"+expense.itemPrice.toString()
        }
        return expenseView
    }
}