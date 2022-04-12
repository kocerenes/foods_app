package com.example.foodsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodsapp.entity.Foods
import com.example.foodsapp.repo.FoodsDAORepository

class HomePageViewModel : ViewModel() {

    var foodsList = MutableLiveData<List<Foods>>()
    var foodRepo = FoodsDAORepository()

    init {
        loadFoods()
        foodsList = foodRepo.getFoods()
    }

    fun loadFoods(){
        foodRepo.getAllFoods()
    }

}