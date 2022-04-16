package com.example.foodsapp

import android.app.Activity
import android.app.Application
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
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.foodsapp.entity.Foods
import com.example.foodsapp.ui.theme.FoodsAppTheme
import com.example.foodsapp.viewmodel.HomePageViewModel
import com.example.foodsapp.viewmodel.HomePageViewModelFactory
import com.google.gson.Gson
import com.skydoves.landscapist.glide.GlideImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PagePass()
                }
            }
        }
    }
}

@Composable
fun PagePass(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home_page"){
        composable("home_page"){
            HomePage(navController = navController)
        }
        composable("detail_page/{food}", arguments = listOf(
            navArgument("food"){type = NavType.StringType}
        )){
            val json = it.arguments?.getString("food")
            val food = Gson().fromJson(json, Foods::class.java)
            DetailPage(food = food)
        }
    }
}

@Composable
fun HomePage(navController: NavController) {

    val context = LocalContext.current
    val viewmodel: HomePageViewModel = viewModel(
        factory = HomePageViewModelFactory(context.applicationContext as Application)
    )

    val foodList = viewmodel.foodsList.observeAsState(listOf())

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
                    count = foodList.value!!.count(),
                    itemContent = {
                        val food = foodList.value!![it]
                        Card(
                            modifier = Modifier
                                .padding(all = 5.dp)
                                .fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.clickable {
                                    val foodJson = Gson().toJson(food)
                                    navController.navigate("detail_page/$foodJson")
                                }
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .padding(all = 10.dp)
                                        .fillMaxWidth()
                                ) {
                                    //Glide kullanarak apiden resim çekme
                                    GlideImage(
                                        imageModel = "http://kasimadalan.pe.hu/yemekler/resimler/${food.food_name}",
                                        modifier = Modifier.size(100.dp)
                                    )

                                    /*val activity = (LocalContext.current as Activity)
                                    Image(
                                        bitmap = ImageBitmap.imageResource(
                                            id = activity.resources.getIdentifier(
                                                food.food_image, "drawable", activity.packageName
                                            )
                                        ), contentDescription = "", modifier = Modifier.size(100.dp)
                                    )*/
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

    }
}