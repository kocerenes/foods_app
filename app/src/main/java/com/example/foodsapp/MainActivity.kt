package com.example.foodsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
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

    LaunchedEffect(key1 = true){
        val food1 = Foods(1,"Köfte","köfte",18)
        val food2 = Foods(2,"Ayran","ayran",4)
        val food3 = Foods(3,"Fanta","fanta",5)
        val food4 = Foods(4,"Makarna","makarna",13)
        val food5 = Foods(5,"Kadayıf","kadayıf",24)
        val food6 = Foods(6,"Baklava","baklava",29)

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
                title = {Text(text = "Yemekler")},
                backgroundColor = colorResource(id = R.color.essentialColor),
                contentColor = colorResource(id = R.color.white)
            )
        },
        content = {

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