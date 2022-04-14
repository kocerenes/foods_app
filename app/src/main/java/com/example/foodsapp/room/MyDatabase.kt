package com.example.foodsapp.room

import android.content.Context
import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.foodsapp.entity.Foods

@Database(entities = [Foods::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun foodsDAO() : FoodsDAO

    companion object{
        var INSTANCE:MyDatabase? = null

        fun databaseAccess(context: Context):MyDatabase?{
            if (INSTANCE==null){
                synchronized(Database::class){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MyDatabase::class.java,
                        "yemekler.sqlite"
                    ).createFromAsset("yemekler.sqlite").build()
                }
            }
            return INSTANCE
        }

    }

}