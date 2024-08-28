package com.example.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack.ui.theme.JetPackTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val dataList = rememberSaveable {
                mutableStateOf(mockData())
            }
            var totalDiscount by rememberSaveable { mutableIntStateOf(0) }
            JetPackTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ),
                            title = {
                                Text(
                                    text = "Menu ",
                                    color = Color.White,
                                )
                            },
                        )
                    },
                    bottomBar = {
                        BottomBarContent(
                            total = totalDiscount,
                            onClear = {
                                totalDiscount = 0
                            },
                        )
                    },
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {

                        CardListView(itemModel = dataList.value) { discount ->
                            totalDiscount += discount
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun BottomBarContent(total: Int, onClear: () -> Unit) {
    BottomAppBar(containerColor = MaterialTheme.colorScheme.primary) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Total : $total")
            IconButton(
                onClick = { onClear() },
            ) {
                Icon(Icons.Filled.Delete, null)
            }
        }
    }
}

@Composable
fun CardListView(
    itemModel: List<ItemResponse>, discount: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(3.dp), contentPadding = PaddingValues(8.dp)
    ) {
        items(itemModel) { item ->
            CardItem(
                itemModel = item,
                onCheckedChange = { isChecked: Boolean ->
                    item.isSold = isChecked
                },
                {
                    discount.invoke(it)
                },
            )
        }
    }
}

@Composable
fun CardItem(
    itemModel: ItemResponse, onCheckedChange: ((Boolean) -> Unit), discount: (Int) -> Unit,
) {
    Card(shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .clickable {
                discount.invoke(itemModel.discount)
            }) {
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            //TODO: image from Network
//            AsyncImage(
//                model = itemModel.imageResource,
//                contentDescription = null,
//                modifier = Modifier.size(90.dp)
//            )
            Checkbox(
                checked = itemModel.isSold,
                onCheckedChange = { checked ->
                    itemModel.isSold = checked
                    onCheckedChange(checked)
                }
            )
            Column(
                modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = itemModel.description,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "price : ${itemModel.discount}",
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }

}

@Composable
fun CustomTextInputComponent(
    textValue: String,
    onTextChanged: (String) -> Unit,
    keyboardType: KeyboardType? = KeyboardType.Text,
) {
    var textFieldValue by remember {
        mutableStateOf(TextFieldValue(text = textValue))
    }
    TextField(keyboardOptions = KeyboardOptions(
        keyboardType = keyboardType ?: KeyboardType.Text
    ),
        value = textFieldValue,
        onValueChange = { newValue ->
            textFieldValue = newValue
            onTextChanged(newValue.text)
        })
}

private fun mockData(): List<ItemResponse> {
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackTheme {}
}


data class ItemResponse(
    val imageResource: String,
    val title: String,
    val description: String,
    val discount: Int,
    var isSold: Boolean
)