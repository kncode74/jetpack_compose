package com.example.jetpack.ui.Todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpack.models.TodoResponse

class ToDoListViewModel : ViewModel() {
    // กำหนด _todoList เป็น MutableLiveData เพื่อให้สามารถอัพเดตข้อมูลได้
    private var _todoList = MutableLiveData<List<TodoResponse>>()

    // ให้ผู้ใช้ภายนอกสามารถอ่านค่าจาก todoList ได้ผ่าน LiveData
    val todoList: LiveData<List<TodoResponse>> = _todoList

    init {
        // โหลดข้อมูลเริ่มต้นเมื่อ ViewModel ถูกสร้างขึ้น
        getAllTodo()
    }


    private fun getAllTodo() {
        _todoList.value = TodoListManager.getAllTodo()
    }

    fun addTodo(title: String) {
        TodoListManager.addTodo(title)
        getAllTodo()

    }

    fun deleteTodo(id: Int) {
        TodoListManager.deleteTodo(id)
        getAllTodo()
    }

    fun selectItem(index: Int) {
        TodoListManager.selectItem(index)
        getAllTodo()
    }

}