package com.example.foodsapp.repo

import androidx.lifecycle.MutableLiveData
import com.example.foodsapp.entity.Foods

class FoodsDAORepository {

    var foodsList = MutableLiveData<List<Foods>>()

    init {
        foodsList = MutableLiveData()
    }

    fun getFoods() : MutableLiveData<List<Foods>>{
        return foodsList
    }

    fun getAllFoods(){
        val list = mutableListOf<Foods>()
        val food1 = Foods(1, "Köfte", "kofte", 18)
        val food2 = Foods(2, "Ayran", "ayran", 4)
        val food3 = Foods(3, "Fanta", "fanta", 5)
        val food4 = Foods(4, "Makarna", "makarna", 13)
        val food5 = Foods(5, "Kadayıf", "kadayif", 24)
        val food6 = Foods(6, "Baklava", "baklava", 29)

        list.add(food1)
        list.add(food2)
        list.add(food3)
        list.add(food4)
        list.add(food5)
        list.add(food6)

        foodsList.value = list
    }

}