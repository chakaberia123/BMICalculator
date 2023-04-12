package com.example.bmi_goga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightText = findViewById<EditText>(R.id.etWeight)
        val heightText = findViewById<EditText>(R.id.etHeight)
        val calcButton = findViewById<Button>(R.id.btnCalculate)
        val indexText = findViewById<TextView>(R.id.tvResult)
        val resultDescription = findViewById<TextView>(R.id.tvColor)
        val cardView = findViewById<CardView>(R.id.cvResult)


        calcButton.setOnClickListener {
            val weight = weightText.text.toString()
            val height = heightText.text.toString()

            if (weight.isEmpty()){
                Toast.makeText(this, "Please enter weight", Toast.LENGTH_SHORT).show()
            }else if (height.isEmpty()){
                Toast.makeText(this, "Please enter height", Toast.LENGTH_SHORT).show()
            }else{

                cardView.visibility = VISIBLE
            val bmi = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))
//            val myString = bmi.toString()
//            val firstFiveDigits = myString.substring(0, 5)
//            resultText.text = firstFiveDigits
            val firstFiveDigits = String.format("%.2f", bmi)
            indexText.text = firstFiveDigits

            var color = 0
            var resultText = ""


            if (bmi < 16.49){
                resultText = "Seriously Underweight"
                color = R.color.seriously_underweight
            } else if (bmi > 16.50 && bmi < 18.49){
                resultText = "Underweight"
                color = R.color.underweight
            } else if (bmi > 18.50 && bmi < 24.99){
                resultText = "Healthy"
                color = R.color.normal
            } else if (bmi > 25.00 && bmi < 29.99){
                resultText = "Overweight"
                color = R.color.overweight
            } else if (bmi > 30.00){
                resultText = "Obese"
                color = R.color.obese

            }

            resultDescription.setTextColor(ContextCompat.getColor(this,color))
            resultDescription.text = resultText


        }

    }
}
}