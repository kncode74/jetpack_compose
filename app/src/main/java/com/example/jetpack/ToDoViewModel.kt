package com.example.jetpack.com.example.jetpack

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpack.TodoResponse

class ToDoViewModel : ViewModel() {
    private var _todoList = MutableLiveData<List<TodoResponse>>()
    val todoList : LiveData<List<TodoResponse>> = _todoList

    init {
        getAllTodo()
    }


    fun getAllTodo(){
        _todoList.value = TodoManager.getAllTodo().reversed()
    }

    fun addTodo(title : String){
        TodoManager.addTodo(title)
        getAllTodo()

    }

    fun deleteTodo(id : Int){
        TodoManager.deleteTodo(id)
        getAllTodo()
    }

}