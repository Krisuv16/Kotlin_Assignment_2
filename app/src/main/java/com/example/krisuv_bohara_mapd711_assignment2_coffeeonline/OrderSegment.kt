package com.example.krisuv_bohara_mapd711_assignment2_coffeeonline

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.krisuv_bohara_mapd711_assignment2_coffeeonline.fragments.OrderScreenOne

/**
 * Main class for connecting all three order fragments
 */
class OrderSegment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Set the order segment layout from resource
        setContentView(R.layout.order_segment)

        /**
         * When order is instantiated the function below carry out
         * Object of OrderScreenOne is created which then is placed onto fragment container
         */
        val orderScreenOne = OrderScreenOne()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, orderScreenOne).commit()
    }
}