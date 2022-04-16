package com.example.foodsapp.repo

import android.app.Application
import android.provider.ContactsContract
import androidx.lifecycle.MutableLiveData
import androidx.room.Database
import com.example.foodsapp.entity.Foods
import com.example.foodsapp.entity.FoodsAnswer
import com.example.foodsapp.retrofit.ApiUtils
import com.example.foodsapp.retrofit.FoodsDAOInterface
import com.example.foodsapp.room.MyDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodsDAORepository(var application: Application) {

    var foodsList = MutableLiveData<List<Foods>>()
    //var db : MyDatabase
    var foodsDaoInterface:FoodsDAOInterface

    init {
        foodsDaoInterface = ApiUtils.getFoodsDAOInterface()
        //db = MyDatabase.databaseAccess(application)!!
        foodsList = MutableLiveData()
    }

    fun getFoods() : MutableLiveData<List<Foods>>{
        return foodsList
    }

    fun getAllFoods(){

        foodsDaoInterface.allFoods().enqueue(object :Callback<FoodsAnswer>{
            override fun onFailure(call: Call<FoodsAnswer>?, t: Throwable?) {}
            override fun onResponse(call: Call<FoodsAnswer>, response: Response<FoodsAnswer>) {
                foodsList.value = response.body().foods
            }
        })

        /*val job:Job = CoroutineScope(Dispatchers.Main).launch {
            foodsList.value = db.foodsDAO().allFoods()
        }*/
    }

}