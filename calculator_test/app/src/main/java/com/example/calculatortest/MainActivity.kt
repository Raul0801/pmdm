package com.example.calculatortest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var inText: TextView
    private lateinit var screen: TextView
    private lateinit var displayText: TextView
    private lateinit var display: String
    private lateinit var operatorUsed: String
    private lateinit var result: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val deleteVal = findViewById<Button>(R.id.button_delete)
        deleteVal.setOnClickListener { deleteNumber() }

        screen = findViewById(R.id.in_box)
        screen.text = display
        inText = findViewById(R.id.in_box)
        displayText = findViewById(R.id.out_box)
    }

    private fun onClickNumber(v: View) {
        val but: Button = v as Button
        display += but.text
        append(display)
        display = ""
    }

    private fun onClickOperator(v: View) {
        val but: Button = v as Button
        display += but.text
        if (endsWithOperator()) {

        }
    }

    private fun replace(str: String) {
        inText.text.substring(0, inText.text.length-1)
        append(str)
    }

    private fun endsWithOperator(): Boolean {
        return getInput().endsWith("+") || getInput().endsWith("-") || getInput().endsWith("*") || getInput().endsWith("/")
    }

    private fun deleteNumber() {
        this.inText.text.drop(getInput().length - 1)
    }

    private fun getInput(): String {
        return inText.text.toString()
    }

    private fun onClearButton(v: View) {
        inText.text = ""
        displayText.text = ""
    }

    private fun append(str: String) {
        val currentText = inText.text
        val sb = StringBuilder()

        sb.append(currentText).append(str)
        val out = sb.toString()

        this.inText.text = out
    }
}