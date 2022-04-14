package com.example.foodsapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "yemekler")
data class Foods(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "yemek_id") @NotNull var food_id:Int,
    @ColumnInfo(name = "yemek_adi") @NotNull var food_name:String,
    @ColumnInfo(name = "yemek_resim_adi") @NotNull var food_image:String,
    @ColumnInfo(name = "yemek_fiyat") @NotNull var food_price:Int)