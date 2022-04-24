package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvTodos.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.rvTodos.adapter = TodosAdapter(
            mutableListOf
            (ToDoList("Clean House",false),
            ToDoList("Do Homework",false),
            ToDoList("Buy groceries",false))
        ).apply {
            setOnItemClickListener {
                list.remove(it)
                notifyItemRemoved(list.indexOf(it))
            }
            }

        binding.btnAdd.setOnClickListener {
            val newToDoText = binding.etEnterTodo.text.toString()
           if (newToDoText.isNotEmpty())
           {
              binding.rvTodos.adapter = TodosAdapter(mutableListOf
                  (ToDoList(title,false)).apply
              {
                  // list.add()  <--- list ვერ გადმოვიტანე და რომელი პარამეტრი უნდა შევცვალო,
                  // ვერ მივხვდი
              })

           }
        }
        }

    }


