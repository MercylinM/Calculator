package com.example.scientificcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var etNum1: EditText
    lateinit var etNum2: EditText
    lateinit var btnAdd: Button
    lateinit var btnMinus: Button
    lateinit var btnMultiply: Button
    lateinit var btnDivide: Button
    lateinit var tvResult: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        castViews()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun castViews(){
        etNum1 =findViewById(R.id.etNum1)
        etNum2 = findViewById(R.id.etNum2)
        btnAdd = findViewById(R.id.btnAdd)
        btnMinus = findViewById(R.id.btnMinus)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivide)
        tvResult = findViewById(R.id.tvResult)
    }

    override fun onResume() {
        super.onResume()
        btnAdd.setOnClickListener {
           obtainValues("+")
        }

        btnMinus.setOnClickListener {
            obtainValues("-")
        }

        btnMultiply.setOnClickListener {
            obtainValues("x")
        }

        btnDivide.setOnClickListener {
            obtainValues("/")
        }
    }

    fun obtainValues(symbol: String){
        val num1 = etNum1.text.toString()
        val num2 = etNum2.text.toString()

        if (num1.isBlank()){
            etNum1.error = "Num 1 is required"
            return
        }

        if (num2.isBlank()){
            etNum2.error = "Num 2 is required"
            return
        }

        performCalculation(symbol,num1,num2)
    }

    fun performCalculation(symbol: String, num1: String, num2: String){
        var result = when(symbol){
            "+" -> num1.toInt() + num2.toDouble()
            "-" -> num1.toInt() - num2.toDouble()
            "x" -> num1.toInt() * num2.toDouble()
            "/" -> num1.toInt() / num2.toDouble()

            else -> {0.0}
        }
        tvResult.text = result.toString()
    }
}