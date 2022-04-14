package com.example.foodsapp.room

import androidx.room.Dao
import androidx.room.Query
import com.example.foodsapp.entity.Foods

@Dao
interface FoodsDAO {

    @Query("SELECT * FROM yemekler")
    suspend fun allFoods() : List<Foods>

}