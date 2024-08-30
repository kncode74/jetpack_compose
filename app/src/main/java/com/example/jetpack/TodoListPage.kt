package com.example.jetpack

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
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoListPage() {
    val dataList = rememberSaveable {
        mutableStateOf(mockData())
    }
    var totalDiscount by rememberSaveable { mutableIntStateOf(0) }
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
            CardItemContent(
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
fun CardItemContent(
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