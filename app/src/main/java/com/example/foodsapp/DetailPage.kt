package com.example.foodsapp

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource

@Composable
fun DetailPage() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Köfte") },
                backgroundColor = colorResource(id = R.color.essentialColor),
                contentColor = colorResource(id = R.color.white)
            )
        },
        content = {

        }
    )
}