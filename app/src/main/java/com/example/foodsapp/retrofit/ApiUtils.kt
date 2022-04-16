package com.example.foodsapp.retrofit

class ApiUtils {
    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getFoodsDAOInterface():FoodsDAOInterface{
            return RetrofitClient.getClient(BASE_URL).create(FoodsDAOInterface::class.java)
        }
    }
}