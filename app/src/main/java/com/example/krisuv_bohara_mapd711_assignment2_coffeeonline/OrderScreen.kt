package com.example.krisuv_bohara_mapd711_assignment2_coffeeonline

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class OrderScreen : AppCompatActivity() {
    private var radioGroup: RadioGroup? = null
    private var radioButton: RadioButton? = null

    private var chipGroup: ChipGroup? = null
    private var chip: Chip? = null

    private var twoShots: CheckBox? = null
    private var sugar: CheckBox? = null
    private var cream: CheckBox? = null
    private var wholeMilk: CheckBox? = null
    private var twoPerMilk: CheckBox? = null
    private var nonFatMilk: CheckBox? = null
    private var almondMilk: CheckBox? = null

    private var layoutOne: LinearLayout? = null
    private var layoutTwo: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_screen)

        chipGroup = findViewById<View>(R.id.chipGroup) as ChipGroup
        radioGroup = findViewById<View>(R.id.radioGroup1) as RadioGroup
        twoShots = findViewById<View>(R.id.twoShots) as CheckBox
        sugar = findViewById<View>(R.id.sugar) as CheckBox
        cream = findViewById<View>(R.id.cream) as CheckBox
        wholeMilk = findViewById<View>(R.id.wholeMilk) as CheckBox
        twoPerMilk = findViewById<View>(R.id.twoPercentMilk) as CheckBox
        nonFatMilk = findViewById<View>(R.id.nonFatMilk) as CheckBox
        almondMilk = findViewById<View>(R.id.almondMilk) as CheckBox
        val continueBtn = findViewById<View>(R.id.continueOne) as Button
        layoutOne = findViewById<View>(R.id.linearLayout) as LinearLayout
        layoutTwo = findViewById<View>(R.id.linearLayout2) as LinearLayout


        continueBtn.setOnClickListener{
            if(chip == null ){
                Toast.makeText(this, "Please Select a Coffee", Toast.LENGTH_SHORT).show()
            }else if(radioButton == null ){
                Toast.makeText(this, "Please Select Coffee Size", Toast.LENGTH_SHORT).show()
            }else if(!twoShots!!.isChecked && !sugar!!.isChecked && !cream!!.isChecked && !wholeMilk!!.isChecked  && !twoPerMilk!!.isChecked  && !nonFatMilk!!.isChecked  && !almondMilk!!.isChecked ) {
                Toast.makeText(this, "Please Select atLeast one Option", Toast.LENGTH_SHORT).show()
            }else{
                println("asdsadasdsadasdsadasd")
                println("Krisuv")
                println("asdsadasdsadasdsadasd")
            }
        }


        chipGroup!!.setOnCheckedChangeListener { group, checkedIds ->
            chip = group.findViewById(checkedIds)
            if(chip !=null){
                layoutOne!!.visibility = View.VISIBLE
            }else{
                clearData()
            }
        }

        radioGroup!!.setOnCheckedChangeListener { radioGroup, i ->
            radioButton = radioGroup.findViewById(i)
            if(radioButton !=null){
                layoutTwo!!.visibility = View.VISIBLE
            }else{
                layoutTwo!!.visibility = View.GONE
            }
        }


    }


    private fun clearData(){
        layoutOne!!.visibility = View.GONE
        layoutTwo!!.visibility = View.GONE
        radioGroup!!.clearCheck()
        twoShots!!.isChecked = false
        sugar!!.isChecked = false
        cream!!.isChecked = false
        wholeMilk!!.isChecked = false
        twoPerMilk!!.isChecked = false
        nonFatMilk!!.isChecked = false
        almondMilk!!.isChecked = false
    }
}