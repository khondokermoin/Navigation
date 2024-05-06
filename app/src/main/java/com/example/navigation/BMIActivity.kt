package com.example.navigation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.navigation.databinding.ActivityBmiactivityBinding

class BMIActivity : AppCompatActivity() {
    lateinit var binding: ActivityBmiactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calBtn.setOnClickListener{
            binding.calCard.setVisibility(View.VISIBLE)
            val weight = binding.weightEt.text.toString()
            val height = binding.heightEt.text.toString()

            if (validateInput(weight, height)){
                val bmi = weight.toDouble()/((height.toDouble()/100)*(height.toDouble()/100))
                val bmiDigit = String.format("%2f", bmi).toDouble()
                displayResult(bmiDigit)
            }
        }
    }

    private fun displayResult(bmiDigit: Double) {
        var result = ""
        var color = 0
        var range = ""

        when{
            bmiDigit <18.50->{
                result = "Underweight"
                color = R.color.under_weight
                range = "(Underweight range is less than 19"
            }
            bmiDigit in 18.50..24.99->{
                result = "Healthy"
                color = R.color.normal
                range = "(Healthy range is 18.50 - 24.99)"
            }
            bmiDigit in 25.00..29.99->{
                result = "Overweight"
                color = R.color.over_weight
                range = "(Overweight range is 25.00 - 29.99)"
            }
            bmiDigit >29.00->{
                result = "Obese"
                color = R.color.obese
                range = "(Obese range is greater than 25.00 - 29.99)"
            }
        }
        binding.countTxt.setTextColor(ContextCompat.getColor(this,color))
        binding.countTxt.text = bmiDigit.toString()
        binding.resultTxt.setTextColor(ContextCompat.getColor(this,color))
        binding.resultTxt.text = bmiDigit.toString()
        binding.rangeTxt.setTextColor(ContextCompat.getColor(this,color))
        binding.rangeTxt.text = range
    }

    private fun validateInput(weight:String, height:String):Boolean{
        return when{
            weight.isNullOrEmpty()->{
                Toast.makeText(this, "Weight is empty", Toast.LENGTH_SHORT).show()
                return false
            }
            height.isNullOrEmpty()->{
                Toast.makeText(this, "Height is empty", Toast.LENGTH_SHORT).show()
                return false
            }
            else->{
                return true
            }
        }
    }
}