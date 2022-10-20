package com.example.krisuv_bohara_mapd711_assignment2_coffeeonline

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.krisuv_bohara_mapd711_assignment2_coffeeonline.fragments.OrderScreenOne

class OrderSegment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_segment)

        val orderScreenOne = OrderScreenOne()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, orderScreenOne).commit()
    }
}