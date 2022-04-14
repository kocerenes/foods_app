package com.example.foodsapp.repo

import android.app.Application
import android.provider.ContactsContract
import androidx.lifecycle.MutableLiveData
import androidx.room.Database
import com.example.foodsapp.entity.Foods
import com.example.foodsapp.room.MyDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class FoodsDAORepository(var application: Application) {

    var foodsList = MutableLiveData<List<Foods>>()
    var db : MyDatabase

    init {
        db = MyDatabase.databaseAccess(application)!!
        foodsList = MutableLiveData()
    }

    fun getFoods() : MutableLiveData<List<Foods>>{
        return foodsList
    }

    fun getAllFoods(){
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            foodsList.value = db.foodsDAO().allFoods()
        }
    }

}