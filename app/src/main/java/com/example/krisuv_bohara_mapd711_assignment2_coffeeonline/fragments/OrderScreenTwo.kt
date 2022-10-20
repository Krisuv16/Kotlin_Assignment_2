package com.example.krisuv_bohara_mapd711_assignment2_coffeeonline.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.krisuv_bohara_mapd711_assignment2_coffeeonline.R

class OrderScreenTwo : Fragment() {
    private var fullName: EditText? = null
    private var phoneNumber: EditText? = null
    private var cardNumber: EditText? = null
    private var month: EditText? = null
    private var year: EditText? = null
    private var ccv: EditText? = null
    private var pickUpTime: TimePicker? = null
    private var layout: LinearLayout? = null
    private var dropDownValue: Spinner? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_order_screen_two, container, false)
        val value = arguments?.getString("YourKey")
        pickUpTime = view.findViewById<View>(R.id.timePicker1) as TimePicker
        fullName = view.findViewById<View>(R.id.fullNameEditText) as EditText
        phoneNumber = view.findViewById<View>(R.id.phoneNumberEditText) as EditText
        cardNumber = view.findViewById<View>(R.id.cardNumberEditText) as EditText
        month = view.findViewById<View>(R.id.monthEditText) as EditText
        year = view.findViewById<View>(R.id.yearEditText) as EditText
        ccv = view.findViewById<View>(R.id.ccvEditText) as EditText
        val btn = view.findViewById<View>(R.id.continueTwo) as Button
        layout = view.findViewById<View>(R.id.linearLayoutScreenTwo) as LinearLayout
        dropDownValue = view.findViewById<View>(R.id.spinnerDropDown) as Spinner


        phoneNumber!!.addTextChangedListener {
            if(phoneNumber!!.text.isNotEmpty() && fullName!!.text.isNotEmpty() && pickUpTime != null){
                layout!!.visibility = View.VISIBLE
            }else if(phoneNumber!!.text.isEmpty() && fullName!!.text.isEmpty()){
                layout!!.visibility = View.GONE
            }
        }

        fullName!!.addTextChangedListener {
            if(phoneNumber!!.text.isNotEmpty() && fullName!!.text.isNotEmpty() && pickUpTime != null){
                layout!!.visibility = View.VISIBLE
            }else if(phoneNumber!!.text.isEmpty() && fullName!!.text.isEmpty()){
                layout!!.visibility = View.GONE
            }
        }


        btn.setOnClickListener{
            val monthInt: Int? = month!!.text.toString().toIntOrNull()
            val yearInt: Int? = year!!.text.toString().toIntOrNull()

            if(fullName!!.text.isEmpty()){
                Toast.makeText(activity, "Please Enter Full Name", Toast.LENGTH_SHORT).show()
            }else if(phoneNumber!!.text.isEmpty()){
                Toast.makeText(activity, "Please Enter Phone Number", Toast.LENGTH_SHORT).show()
            }else if(phoneNumber!!.text.length != 10){
                Toast.makeText(activity, "Phone Number length not 10", Toast.LENGTH_SHORT).show()
            }else if(pickUpTime == null ){
                Toast.makeText(activity, "Please Enter Pick Up Time", Toast.LENGTH_SHORT).show()
            }else if(dropDownValue == null ){
                Toast.makeText(activity, "Please Enter Card Type", Toast.LENGTH_SHORT).show()
            }else if(cardNumber!!.text.isEmpty()){
                Toast.makeText(activity, "Please Enter Card Number", Toast.LENGTH_SHORT).show()
            }else if(cardNumber!!.text.length != 16){
                Toast.makeText(activity, "Card Number length not 16", Toast.LENGTH_SHORT).show()
            }else if(month!!.text.isEmpty()){
            Toast.makeText(activity, "Please Enter Month", Toast.LENGTH_SHORT).show()
            }else if(monthInt!! > 12){
                Toast.makeText(activity, "Please Enter Valid Month 0-12", Toast.LENGTH_SHORT).show()
            }
            else if (yearInt!! < 2021){
                Toast.makeText(activity, "Please Enter Valid Year, before 2022", Toast.LENGTH_SHORT).show()
            }
            else if(year!!.text.isEmpty()){
                Toast.makeText(activity, "Please Enter Year", Toast.LENGTH_SHORT).show()
            }else if(ccv!!.text.isEmpty()){
                Toast.makeText(activity, "Please Enter CCV", Toast.LENGTH_SHORT).show()
            }
        }
        return  view
    }
}