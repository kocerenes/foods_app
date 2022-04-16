package com.example.foodsapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

//@Entity(tableName = "yemekler")
data class Foods(

    @SerializedName("yemek_id")
    @Expose
    var food_id:Int,
    @SerializedName("yemek_adi")
    @Expose
    var food_name:String,
    @SerializedName("yemek_resim_adi")
    @Expose
    var food_image:String,
    @SerializedName("yemek_fiyat")
    @Expose
    var food_price:Int,

    /*
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "yemek_id") @NotNull var food_id: Int,
    @ColumnInfo(name = "yemek_adi") @NotNull var food_name: String,
    @ColumnInfo(name = "yemek_resim_adi") @NotNull var food_image: String,
    @ColumnInfo(name = "yemek_fiyat") @NotNull var food_price: Int*/
)