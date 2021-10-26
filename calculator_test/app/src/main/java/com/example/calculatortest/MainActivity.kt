package com.example.calculatortest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var inText: TextView
    private lateinit var displayText: TextView
    private var display: String = ""
    private var operatorUsed: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inText = findViewById(R.id.in_box)
        displayText = findViewById(R.id.out_box)
    }

    fun onClickNumber(v: View) {
        val but = v as Button
        display += but.text
        append(display)
        display = ""
    }

    fun onClickOperator(v: View) {
        val but: Button = v as Button
        display += but.text
        if (endsWithOperator()) {
            replace(display)
            operatorUsed = but.text.toString()
            display = ""
        } else {
            append(display)
            operatorUsed = but.text.toString()
            display = ""
        }
    }

    private fun replace(str: String) {
        inText.text = inText.text.substring(0, inText.text.length-1)
        append(str)
    }

    private fun endsWithOperator(): Boolean {
        return getInput().endsWith("+") || getInput().endsWith("-") || getInput().endsWith("*") || getInput().endsWith("/")
    }

    fun onDelButton(v: View) {
        if (inText.text.isNotEmpty()) {
        inText.text = inText.text.substring(0, inText.text.length - 1)
        }
    }

    private fun getInput(): String {
        return inText.text.toString()
    }

    fun onClearButton(v: View) {
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

    fun equals(v: View) {
        var input: String = getInput()
        if (!endsWithOperator() and input.isNotEmpty() and !startsWithOperator()) {
            displayText.setText(evaluate(input).toString())
        } else displayText.setText("")
    }

    private fun startsWithOperator(): Boolean {
        return getInput().startsWith("+") || getInput().startsWith("-") || getInput().startsWith("*") || getInput().startsWith("/")
    }

}