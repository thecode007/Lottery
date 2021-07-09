package com.example.myapplication

import android.app.Application
import androidx.lifecycle.Lifecycle

class ApplicationContext: Application(){

    override fun onCreate() {
        super.onCreate()
        DataFaker.populate()
    }
}