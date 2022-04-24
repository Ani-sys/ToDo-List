package com.example.todolist

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.LayoutItemToDoBinding

class TodosAdapter(val list:MutableList<ToDoList> ):RecyclerView.Adapter<TodoViewHolder>() {
    private lateinit var itemClickListener:(ToDoList) -> Unit
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = LayoutItemToDoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
              return TodoViewHolder(binding)
    }

    fun setOnItemClickListener(clickListener: (ToDoList) -> Unit)
    {
        this.itemClickListener = clickListener
    }


    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val toDoListText = list[position]
            holder.binding.tvCleanHouse.text = toDoListText.title
            holder.binding.cbClicked.isChecked = toDoListText.isChecked
        holder.binding.tvCleanHouse.setOnClickListener {
            itemClickListener.invoke(toDoListText)

        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

}

data class ToDoList(
    val title: CharSequence,
    val isChecked:Boolean

    )
class TodoViewHolder(val binding:LayoutItemToDoBinding):RecyclerView.ViewHolder(binding.root)