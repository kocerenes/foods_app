package com.example.foodsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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