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

/**
 * OrderScreenOne class with fragment constructor
 */
class OrderScreenOne : Fragment() {
    /**
     * Variables set for all the field like checkbox and radio group
     */
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

    /**
     * Variable to toggle to show and hide dependent radio groups and checkbox
     */
    private var layoutOne: LinearLayout? = null
    private var layoutTwo: LinearLayout? = null

    /**
     * Declare hashmap to store key-value pairs
     */
    private val hashMap = HashMap<String, String>()

    /**
     * Stores all the selected checkbox values
     */
    private val selectedCheckboxes: ArrayList<String> = ArrayList()

    /**
     * Variable to store all selected checkbox in strings
     */
    private var co = String()

    /**
     * Creates and returns the view associated with first fragment order screen
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /**
         * Instantiates layout of fragment_order_screen_one into view
         */
        val view =  inflater.inflate(R.layout.fragment_order_screen_one, container, false)

        /**
         * access properties of radio groups and checkbox views
         */
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


        /**
         * Set the click listener on continue button
         */
        continueBtn.setOnClickListener{
            co = ""
            hashMap.clear()
            selectedCheckboxes.clear()
            /**
             * Check if all the required fields have been selected
             * if not displays error message accordingly
             */
            if(chip == null ){
                Toast.makeText(activity, "Please Select a Coffee", Toast.LENGTH_SHORT).show()
            }else if(radioButton == null ){
                Toast.makeText(activity, "Please Select Coffee Size", Toast.LENGTH_SHORT).show()
            }else if(!twoShots!!.isChecked && !sugar!!.isChecked
                && !cream!!.isChecked && !wholeMilk!!.isChecked
                && !twoPerMilk!!.isChecked  && !nonFatMilk!!.isChecked  && !almondMilk!!.isChecked ) {
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

                /**
                 * Convert array of selected check boxes to a string
                 */
                co = selectedCheckboxes.joinToString()

                /**
                 * stores coffee, sizes and options to hashmap
                 */
                hashMap["coffee"] = chip!!.text.toString()
                hashMap["size"] = radioButton!!.text.toString()
                hashMap["options"] = co

                /**
                 * Object of OrderScreenTwo class
                 */
                val ldf = OrderScreenTwo()

                /**
                 * creates a bundle to pass data from order screen one
                 */
                val args = Bundle()
                args.putSerializable("orderScreenOneMap", hashMap)
                ldf.arguments = args

                /**
                 * Fragment container is loaded with OrderScreenTwo after successful completion on First Fragments
                 */
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.fragmentContainer, ldf)?.addToBackStack(null)
                    ?.commit()

            }
        }

        /**
         * Toggle to show and hide on coffee selected
         */
        chipGroup!!.setOnCheckedChangeListener { group, checkedIds ->
            chip = group.findViewById(checkedIds)
            if(chip !=null){
                layoutOne!!.visibility = View.VISIBLE
            }else{
                clearData()
            }
        }

        /**
         * Toggle to show and hide on coffee size selected
         */
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

    /**
     * Unset all the data from Order Screen
     */
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