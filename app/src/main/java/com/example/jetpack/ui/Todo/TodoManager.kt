package com.example.jetpack.ui.Todo

import com.example.jetpack.models.TodoResponse

object TodoManager {

    private val todoList = mutableListOf(
        TodoResponse(
            title = "Unikwan",
            imageResource = "https://i.pinimg.com/564x/28/fb/47/28fb47d48d382c0debb7ea6d93dc79ed.jpg",
            discount = 20,
            isSold = true,

            ), TodoResponse(
            title = "Unikwan",
            imageResource = "https://i.pinimg.com/564x/28/fb/47/28fb47d48d382c0debb7ea6d93dc79ed.jpg",
            discount = 20,
            isSold = true,

            ), TodoResponse(
            title = "Unikwan",
            imageResource = "https://i.pinimg.com/564x/28/fb/47/28fb47d48d382c0debb7ea6d93dc79ed.jpg",
            discount = 20,
            isSold = true,

            ), TodoResponse(
            title = "Unikwan",
            imageResource = "https://i.pinimg.com/564x/28/fb/47/28fb47d48d382c0debb7ea6d93dc79ed.jpg",
            discount = 20,
            isSold = true,

            ), TodoResponse(
            title = "Unikwan",
            imageResource = "https://i.pinimg.com/564x/28/fb/47/28fb47d48d382c0debb7ea6d93dc79ed.jpg",
            discount = 20,
            isSold = true,

            ), TodoResponse(
            title = "Unikwan",
            imageResource = "https://i.pinimg.com/564x/28/fb/47/28fb47d48d382c0debb7ea6d93dc79ed.jpg",
            discount = 20,
            isSold = false,

            ), TodoResponse(
            title = "Unikwan",
            imageResource = "https://i.pinimg.com/564x/28/fb/47/28fb47d48d382c0debb7ea6d93dc79ed.jpg",
            discount = 20,
            isSold = true,

            ), TodoResponse(
            title = "Unikwan",
            imageResource = "https://i.pinimg.com/564x/28/fb/47/28fb47d48d382c0debb7ea6d93dc79ed.jpg",
            discount = 20,
            isSold = false,

            ), TodoResponse(
            title = "Unikwan",
            imageResource = "https://i.pinimg.com/564x/28/fb/47/28fb47d48d382c0debb7ea6d93dc79ed.jpg",
            discount = 20,
            isSold = true,
        )
    )


    fun getAllTodo(): List<TodoResponse> {
        return todoList
    }

    fun addTodo(title: String) {
        todoList.add(
            TodoResponse(
                title = title,
                discount = 0,
                imageResource = "",
                isSold = false
            )
        )
    }

    fun deleteTodo(index: Int) {
        todoList.removeAt(index)
    }
}