package com.example.krisuv_bohara_mapd711_assignment2_coffeeonline.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.krisuv_bohara_mapd711_assignment2_coffeeonline.R

class OrderScreenThree : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /**
         * Creates and returns the view associated with third fragment order screen
         */
        val view =  inflater.inflate(R.layout.fragment_order_screen_three, container, false)

        /**
         * Return the arguments supplied from OrderScreenTwo Fragments
         */
        val b = this.arguments

        /**
         * Access value transferred from order screen one and two
         */
        var screenOneMap: HashMap<String, String> = HashMap()
        screenOneMap =  b!!.getSerializable("orderScreenOneMap") as HashMap<String, String>

        var screenTwoMap: HashMap<String, String> = HashMap()
        screenTwoMap =  b.getSerializable("orderScreenTwoMap") as HashMap<String, String>

        /**
         * access properties of text views
         */
        val fullName = view.findViewById<View>(R.id.fullNameValue) as TextView
        val phoneNumber = view.findViewById<View>(R.id.phoneNumberValue) as TextView
        val pickUpTime = view.findViewById<View>(R.id.pickUpTimeValue) as TextView
        val order = view.findViewById<View>(R.id.orderValue) as TextView

        fullName.text = screenTwoMap["fullName"]
        phoneNumber.text = screenTwoMap["phoneNumber"]
        pickUpTime.text = screenTwoMap["time"]

        val msg = "Order: A ${screenOneMap["size"]} ${screenOneMap["coffee"]}, with ${screenOneMap["options"]}"

        order.text = msg

        println(screenOneMap)
        println(screenTwoMap)

        return  view
    }

}