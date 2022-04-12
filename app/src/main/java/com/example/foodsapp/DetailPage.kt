package com.example.foodsapp

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodsapp.entity.Foods

@Composable
fun DetailPage(food: Foods) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = food.food_name) },
                backgroundColor = colorResource(id = R.color.essentialColor),
                contentColor = colorResource(id = R.color.white)
            )
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val activity = (LocalContext.current as Activity)
                Image(
                    bitmap = ImageBitmap.imageResource(
                        id = activity.resources.getIdentifier(
                            food.food_image, "drawable", activity.packageName
                        )
                    ), contentDescription = "", modifier = Modifier.size(250.dp)
                )
                Text(text = "${food.food_price} TL", color = Color.Blue, fontSize = 50.sp)
                Button(
                    onClick = {
                        Log.e("siparis", "${food.food_name} sipariş verildi.")
                    },
                    modifier = Modifier.size(250.dp,50.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.essentialColor),
                        contentColor = colorResource(id = R.color.white)
                    )
                ) {
                    Text(text = "Sipariş ver")
                }
            }
        }
    )
}