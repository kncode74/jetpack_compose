package com.example.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.jetpack.ui.Todo.ToDoListView
import com.example.jetpack.ui.theme.JetPackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val todoViewModel = ViewModelProvider(this)[ToDoListViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            JetPackTheme {
                ToDoListView(viewModel = todoViewModel)
            }
        }
    }
}






