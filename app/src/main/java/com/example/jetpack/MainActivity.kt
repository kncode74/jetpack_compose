package com.example.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpack.ui.theme.JetPackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackTheme {
                ToDoListPage()
            }
        }
    }
}





fun mockData(): List<ItemResponse> {
    return listOf(
        ItemResponse(
            title = "Unikwan",
            imageResource = "https://i.pinimg.com/564x/28/fb/47/28fb47d48d382c0debb7ea6d93dc79ed.jpg",
            description = "림뉴 프샤로 쓸게용♡♡",
            discount = 20,
            isSold = true,

            ), ItemResponse(
            title = "Unikwan",
            imageResource = "https://i.pinimg.com/564x/28/fb/47/28fb47d48d382c0debb7ea6d93dc79ed.jpg",
            description = "림뉴 프샤로 쓸게용♡♡",
            discount = 20,
            isSold = true,

            ), ItemResponse(
            title = "Unikwan",
            imageResource = "https://i.pinimg.com/564x/28/fb/47/28fb47d48d382c0debb7ea6d93dc79ed.jpg",
            description = "림뉴 프샤로 쓸게용♡♡",
            discount = 20,
            isSold = true,

            ), ItemResponse(
            title = "Unikwan",
            imageResource = "https://i.pinimg.com/564x/28/fb/47/28fb47d48d382c0debb7ea6d93dc79ed.jpg",
            description = "림뉴 프샤로 쓸게용♡♡",
            discount = 20,
            isSold = true,

            ), ItemResponse(
            title = "Unikwan",
            imageResource = "https://i.pinimg.com/564x/28/fb/47/28fb47d48d382c0debb7ea6d93dc79ed.jpg",
            description = "림뉴 프샤로 쓸게용♡♡",
            discount = 20,
            isSold = true,

            ), ItemResponse(
            title = "Unikwan",
            imageResource = "https://i.pinimg.com/564x/28/fb/47/28fb47d48d382c0debb7ea6d93dc79ed.jpg",
            description = "림뉴 프샤로 쓸게용♡♡",
            discount = 20,
            isSold = false,

            ), ItemResponse(
            title = "Unikwan",
            imageResource = "https://i.pinimg.com/564x/28/fb/47/28fb47d48d382c0debb7ea6d93dc79ed.jpg",
            description = "림뉴 프샤로 쓸게용♡♡",
            discount = 20,
            isSold = true,

            ), ItemResponse(
            title = "Unikwan",
            imageResource = "https://i.pinimg.com/564x/28/fb/47/28fb47d48d382c0debb7ea6d93dc79ed.jpg",
            description = "림뉴 프샤로 쓸게용♡♡",
            discount = 20,
            isSold = false,

            ), ItemResponse(
            title = "Unikwan",
            imageResource = "https://i.pinimg.com/564x/28/fb/47/28fb47d48d382c0debb7ea6d93dc79ed.jpg",
            description = "림뉴 프샤로 쓸게용♡♡",
            discount = 20,
            isSold = true,
        )
    )
}



