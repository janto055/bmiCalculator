package com.example.and101bmicalculator

import android.R
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.and101bmicalculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculate.setOnClickListener {
            //read the inputted weight and height from binding
            val weightEditText = binding.weight.text.toString().toDouble()
            val heightEditText = binding.height.text.toString().toDouble()

            //calculate the BMI based on inputs
            val resultBMI = calculateBMI(weightEditText, heightEditText)

            //round the BMI
            val roundResult = String.format("%.1f", resultBMI)

            //display to output text binding
            binding.output.text = "$roundResult"
        }
    }

    //BMI calculation formula: weight (lb) / [height (in)]^2 x 703

    public fun calculateBMI (weight : Double, height : Double): Double {
        val BMI = (weight/(height * height)) * 703
        return BMI
    }
}