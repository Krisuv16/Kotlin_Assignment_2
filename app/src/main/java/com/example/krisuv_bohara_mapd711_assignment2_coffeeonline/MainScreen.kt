package com.example.krisuv_bohara_mapd711_assignment2_coffeeonline

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen)
        setTitle(R.string.store_name)
    }
    
}