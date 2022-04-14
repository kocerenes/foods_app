package com.example.foodsapp.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HomePageViewModelFactory(var application: Application): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomePageViewModel(application) as T
    }

}