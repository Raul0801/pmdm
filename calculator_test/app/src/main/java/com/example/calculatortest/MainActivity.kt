package com.example.calculatortest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.calculatortest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var inText: TextView
    private lateinit var displayText: TextView
    private lateinit var binding: ActivityMainBinding
    private val sb = StringBuilder()
    private var display: String = ""
    private var operatorUsed: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        inText = findViewById(R.id.in_box)
        displayText = findViewById(R.id.out_box)

        binding.button0.setOnClickListener {v -> onClickNumber(v)}
        binding.button1.setOnClickListener {v -> onClickNumber(v)}
        binding.button2.setOnClickListener {v -> onClickNumber(v)}
        binding.button3.setOnClickListener {v -> onClickNumber(v)}
        binding.button4.setOnClickListener {v -> onClickNumber(v)}
        binding.button5.setOnClickListener {v -> onClickNumber(v)}
        binding.button6.setOnClickListener {v -> onClickNumber(v)}
        binding.button7.setOnClickListener {v -> onClickNumber(v)}
        binding.button8.setOnClickListener {v -> onClickNumber(v)}
        binding.button9.setOnClickListener {v -> onClickNumber(v)}
        //TODO
        //binding.buttonDecimal.setOnClickListener {v -> onClickNumber(v)}
        binding.buttonDelete.setOnClickListener {onDelButton()}
        binding.buttonClear.setOnClickListener {onClearButton()}
        binding.buttonAdd.setOnClickListener {v -> onClickOperator(v)}
        binding.buttonSub.setOnClickListener {v -> onClickOperator(v)}
        binding.buttonMul.setOnClickListener {v -> onClickOperator(v)}
        binding.buttonDiv.setOnClickListener {v -> onClickOperator(v)}
        binding.buttonEq.setOnClickListener {onEqButton()}
    }

    private fun onClickNumber(v: View) {
        val but = v as Button
        display += but.text
        append(display)
        display = ""
    }

    private fun onClickOperator(v: View) {
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
        return getInput().endsWith("+") || getInput().endsWith("-") || getInput().endsWith("*") || getInput().endsWith("/") || getInput().endsWith("/0")
    }

    private fun onDelButton() {
        if (inText.text.isNotEmpty()) {
        inText.text = inText.text.substring(0, inText.text.length - 1)
        }
    }

    private fun getInput(): String {
        return inText.text.toString()
    }

    private fun onClearButton() {
        inText.text = ""
        displayText.text = ""
    }

    private fun append(str: String) {
        this.inText.text = sb.append(inText.text).append(str).toString()
        sb.clear()
    }

    private fun onEqButton() {
        val input: String = getInput()
        if (!endsWithOperator() and input.isNotEmpty() and !startsWithOperator()) {
            displayText.text = evaluateGeeksForGeeks(input).toString()
        } else displayText.text = ""
    }

    private fun startsWithOperator(): Boolean {
        return getInput().startsWith("+") || getInput().startsWith("-") || getInput().startsWith("*") || getInput().startsWith("/")
    }

}