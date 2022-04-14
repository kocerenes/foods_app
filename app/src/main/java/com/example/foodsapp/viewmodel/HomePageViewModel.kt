package com.example.foodsapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodsapp.entity.Foods
import com.example.foodsapp.repo.FoodsDAORepository

class HomePageViewModel(application: Application) : AndroidViewModel(application) {

    var foodsList = MutableLiveData<List<Foods>>()
    var foodRepo = FoodsDAORepository(application)

    init {
        loadFoods()
        foodsList = foodRepo.getFoods()
    }

    fun loadFoods(){
        foodRepo.getAllFoods()
    }

}