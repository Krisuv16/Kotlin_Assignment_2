package com.example.krisuv_bohara_mapd711_assignment2_coffeeonline.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.krisuv_bohara_mapd711_assignment2_coffeeonline.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup


class OrderScreenOne : Fragment() {
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
    private val hashMap = HashMap<String, String>()
    private val selectedCheckboxes: ArrayList<String> = ArrayList()
    private var co = String()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_order_screen_one, container, false)

        chipGroup = view.findViewById<View>(R.id.chipGroup) as ChipGroup
        radioGroup = view.findViewById<View>(R.id.radioGroup1) as RadioGroup

        twoShots = view.findViewById<View>(R.id.twoShots) as CheckBox
        sugar = view.findViewById<View>(R.id.sugar) as CheckBox
        cream = view.findViewById<View>(R.id.cream) as CheckBox
        wholeMilk = view.findViewById<View>(R.id.wholeMilk) as CheckBox
        twoPerMilk = view.findViewById<View>(R.id.twoPercentMilk) as CheckBox
        nonFatMilk = view.findViewById<View>(R.id.nonFatMilk) as CheckBox
        almondMilk = view.findViewById<View>(R.id.almondMilk) as CheckBox

        layoutOne = view.findViewById<View>(R.id.linearLayout) as LinearLayout
        layoutTwo = view.findViewById<View>(R.id.linearLayout2) as LinearLayout
        val continueBtn = view.findViewById<View>(R.id.continueOne) as Button


        continueBtn.setOnClickListener{
            co = ""
            hashMap.clear()
            selectedCheckboxes.clear()
            if(chip == null ){
                Toast.makeText(activity, "Please Select a Coffee", Toast.LENGTH_SHORT).show()
            }else if(radioButton == null ){
                Toast.makeText(activity, "Please Select Coffee Size", Toast.LENGTH_SHORT).show()
            }else if(!twoShots!!.isChecked && !sugar!!.isChecked && !cream!!.isChecked && !wholeMilk!!.isChecked  && !twoPerMilk!!.isChecked  && !nonFatMilk!!.isChecked  && !almondMilk!!.isChecked ) {
                Toast.makeText(activity, "Please Select atLeast one Option", Toast.LENGTH_SHORT).show()
            }else{
                if(twoShots!!.isChecked){
                   selectedCheckboxes.add(twoShots!!.text.toString())
                }else{
                    selectedCheckboxes.remove(twoShots!!.text.toString())
                }
                if(sugar!!.isChecked){
                    selectedCheckboxes.add(sugar!!.text.toString())
                }else{
                    selectedCheckboxes.remove(sugar!!.text.toString())
                }
                if(cream!!.isChecked){
                    selectedCheckboxes.add(cream!!.text.toString())
                }else{
                    selectedCheckboxes.remove(cream!!.text.toString())
                }
                if(wholeMilk!!.isChecked){
                    selectedCheckboxes.add(wholeMilk!!.text.toString())
                }else{
                    selectedCheckboxes.remove(wholeMilk!!.text.toString())
                }
                if(twoPerMilk!!.isChecked){
                    selectedCheckboxes.add(twoPerMilk!!.text.toString())
                }else{
                    selectedCheckboxes.remove(twoPerMilk!!.text.toString())
                }
                if(nonFatMilk!!.isChecked){
                    selectedCheckboxes.add(nonFatMilk!!.text.toString())
                }else{
                    selectedCheckboxes.remove(nonFatMilk!!.text.toString())
                }
                if(almondMilk!!.isChecked){
                    selectedCheckboxes.add(almondMilk!!.text.toString())
                }else{
                    selectedCheckboxes.remove(almondMilk!!.text.toString())
                }

                co = selectedCheckboxes.joinToString()


                hashMap["coffee"] = chip!!.text.toString()
                hashMap["size"] = radioButton!!.text.toString()
                hashMap["options"] = co
                val ldf = OrderScreenTwo()
                val args = Bundle()
                args.putSerializable("orderScreenOneMap", hashMap)
                ldf.arguments = args

                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.fragmentContainer, ldf)?.addToBackStack(null)
                    ?.commit()

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
        return  view;
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
        co = ""
        selectedCheckboxes.clear()
        hashMap.clear()
    }


}