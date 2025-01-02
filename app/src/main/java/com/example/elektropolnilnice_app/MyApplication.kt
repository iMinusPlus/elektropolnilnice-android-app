package com.example.elektropolnilnice_app

import android.app.Application
import android.widget.Toast

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val text = "Hello toast!"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(this, text, duration) // in Activity
        toast.show()

    }

}