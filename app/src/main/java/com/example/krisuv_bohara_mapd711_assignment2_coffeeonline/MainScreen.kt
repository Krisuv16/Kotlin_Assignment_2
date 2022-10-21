package com.example.krisuv_bohara_mapd711_assignment2_coffeeonline

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*

/**
 * Instantiate main screen of coffee ordering app
 */
class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Set the main screen from layout resource
        setContentView(R.layout.main_screen)


        val btnClick = findViewById<View>(R.id.outlinedButton) as Button

        /**
         * Set the click listener which passes on intent to OrderSegment Class
         */
        btnClick.setOnClickListener {
            val intent = Intent(this, OrderSegment:: class.java)
            startActivity(intent)
        }
    }
}