package com.example.foodsapp.retrofit

import com.example.foodsapp.entity.FoodsAnswer
import retrofit2.Call
import retrofit2.http.GET

interface FoodsDAOInterface {
    @GET("yemekler/tumYemekleriGetir.php")
    fun allFoods():Call<FoodsAnswer>
}