package com.example.foodsapp

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodsapp.ui.theme.FoodsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    HomePage()
                }
            }
        }
    }
}

@Composable
fun HomePage() {

    val foodList = remember {
        mutableStateListOf<Foods>()
    }

    LaunchedEffect(key1 = true) {
        val food1 = Foods(1, "Köfte", "kofte", 18)
        val food2 = Foods(2, "Ayran", "ayran", 4)
        val food3 = Foods(3, "Fanta", "fanta", 5)
        val food4 = Foods(4, "Makarna", "makarna", 13)
        val food5 = Foods(5, "Kadayıf", "kadayif", 24)
        val food6 = Foods(6, "Baklava", "baklava", 29)

        foodList.add(food1)
        foodList.add(food2)
        foodList.add(food3)
        foodList.add(food4)
        foodList.add(food5)
        foodList.add(food6)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Yemekler") },
                backgroundColor = colorResource(id = R.color.essentialColor),
                contentColor = colorResource(id = R.color.white)
            )
        },
        content = {
            LazyColumn {
                items(
                    count = foodList.count(),
                    itemContent = {
                        val food = foodList[it]
                        Card(
                            modifier = Modifier
                                .padding(all = 5.dp)
                                .fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.clickable {

                                }
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .padding(all = 10.dp)
                                        .fillMaxWidth()
                                ) {
                                    val activity = (LocalContext.current as Activity)
                                    Image(
                                        bitmap = ImageBitmap.imageResource(
                                            id = activity.resources.getIdentifier(
                                                food.food_image, "drawable", activity.packageName
                                            )
                                        ), contentDescription = "", modifier = Modifier.size(100.dp)
                                    )
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column(
                                            verticalArrangement = Arrangement.SpaceEvenly,
                                            modifier = Modifier.fillMaxHeight()
                                        ) {
                                            Text(text = food.food_name, fontSize = 20.sp)
                                            Spacer(modifier = Modifier.size(30.dp))
                                            Text(
                                                text = "${food.food_price} tl",
                                                color = Color.Blue
                                            )
                                        }
                                        Icon(
                                            painter = painterResource(id = R.drawable.arrow_img),
                                            contentDescription = ""
                                        )
                                    }
                                }
                            }
                        }
                    }
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodsAppTheme {
        HomePage()
    }
}