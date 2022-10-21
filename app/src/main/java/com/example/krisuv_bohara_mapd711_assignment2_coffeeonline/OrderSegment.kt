package com.example.krisuv_bohara_mapd711_assignment2_coffeeonline

import android.os.Bundle
import android.view.WindowManager
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
         * code to change status bar color
         */
        val window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.resources.getColor(R.color.dark_brown)

        /**
         * When order is instantiated the function below carry out
         * Object of OrderScreenOne is created which then is placed onto fragment container
         */
        val orderScreenOne = OrderScreenOne()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, orderScreenOne).commit()
    }
}