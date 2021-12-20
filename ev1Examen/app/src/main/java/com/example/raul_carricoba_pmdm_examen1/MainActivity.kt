package com.example.raul_carricoba_pmdm_examen1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.raul_carricoba_pmdm_examen1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val yellow = "#FFEB3B"
    private val orange = "#FDBB59"
    private var activePlayer = 0
    private var player1Score = 0
    private var player2Score = 0
    private var currentLvl = 0
    private var remainingClicks = 0
    private var counter1 = 0
    private var counter2 = 0
    private var counter3 = 0
    private var counter4 = 0
    private var counter1PreviousValue = 0
    private var counter2PreviousValue = 0
    private var counter3PreviousValue = 0
    private var counter4PreviousValue = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.buttonNewRound.setOnClickListener {  onNewRound() }
        binding.buttonOk1.setOnClickListener {  onOkBtn1() }
        binding.buttonOk2.setOnClickListener {  onOkBtn2() }
        binding.button1.setOnClickListener { v -> onNumberBtn(v as Button) }
        binding.button2.setOnClickListener { v -> onNumberBtn(v as Button) }
        binding.button3.setOnClickListener { v -> onNumberBtn(v as Button) }
        binding.button4.setOnClickListener { v -> onNumberBtn(v as Button) }
    }

    private fun onNewRound() {
        resetTextViewsAndCounters()
        if(activePlayer == 0) {
            binding.constraintLayout.setBackgroundColor(Color.parseColor(yellow))
            binding.textViewPlayerInfo.text = "Player 1: make up to " + (currentLvl+1).toString() + " clicks"
            binding.textViewPlayerInfo.visibility = View.VISIBLE
            showButtons()
            showTextViews()
            binding.buttonNewRound.visibility = View.INVISIBLE
            binding.buttonOk1.visibility = View.VISIBLE
            activePlayer = 1
            currentLvl += 1
            remainingClicks = currentLvl
        } else {
            binding.constraintLayout.setBackgroundColor(Color.parseColor(orange))
            binding.textViewPlayerInfo.text = "Player 2: make up to " + (currentLvl+1).toString() + " clicks"
            showButtons()
            showTextViews()
            binding.buttonNewRound.visibility = View.INVISIBLE
            binding.buttonOk1.visibility = View.VISIBLE
            activePlayer = 0
            currentLvl += 1
            remainingClicks = currentLvl
        }
    }

    private fun onOkBtn1() {
        if(activePlayer == 0) {
            binding.textViewPlayerInfo.text = "Player 1: try to repeat player 2's clicks (" + (currentLvl).toString() + ") clicks"
            binding.constraintLayout.setBackgroundColor(Color.parseColor(yellow))
            resetTextViewsAndCounters()
            activePlayer = 1
            remainingClicks = currentLvl
            binding.buttonOk1.visibility = View.INVISIBLE
            binding.buttonOk2.visibility = View.VISIBLE
        } else {
            binding.textViewPlayerInfo.text = "Player 2: try to repeat player 1's clicks (" + (currentLvl).toString() + ") clicks"
            binding.constraintLayout.setBackgroundColor(Color.parseColor(orange))
            resetTextViewsAndCounters()
            activePlayer = 0
            remainingClicks = currentLvl
            binding.buttonOk1.visibility = View.INVISIBLE
            binding.buttonOk2.visibility = View.VISIBLE
        }
    }

    private fun onOkBtn2() {
        checkWin()
        binding.textViewPlayerInfo.text = ""
        binding.textViewLvl.text = "Level : " + (currentLvl+1)
        binding.buttonOk2.visibility = View.INVISIBLE
        binding.buttonNewRound.visibility = View.VISIBLE
        hideButtons()
        hideTextViews()
        if(activePlayer == 0) {
            activePlayer = 1
        } else {
            activePlayer = 0
        }
    }

    private fun onNumberBtn(viewButton: Button) {
        if(remainingClicks != 0) {
            when {
                viewButton.text.equals("1") -> {
                    counter1 += 1
                    binding.textViewBtn1.text = counter1.toString()
                    remainingClicks -=1
                }
                viewButton.text.equals("2") -> {
                    counter2 += 1
                    binding.textViewBtn2.text = counter2.toString()
                    remainingClicks -=1
                }
                viewButton.text.equals("3") -> {
                    counter3 += 1
                    binding.textViewBtn3.text = counter3.toString()
                    remainingClicks -=1
                }
                viewButton.text.equals("4") -> {
                    counter4 += 1
                    binding.textViewBtn4.text = counter4.toString()
                    remainingClicks -=1
                }
            }
        } else {
            Toast.makeText(this, "No more clicks remaining in this level.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showButtons() {
        binding.button1.visibility = View.VISIBLE
        binding.button2.visibility = View.VISIBLE
        binding.button3.visibility = View.VISIBLE
        binding.button4.visibility = View.VISIBLE
    }

    private fun hideButtons() {
        binding.button1.visibility = View.INVISIBLE
        binding.button2.visibility = View.INVISIBLE
        binding.button3.visibility = View.INVISIBLE
        binding.button4.visibility = View.INVISIBLE
    }

    private fun showTextViews() {
        binding.textViewBtn1.visibility = View.VISIBLE
        binding.textViewBtn2.visibility = View.VISIBLE
        binding.textViewBtn3.visibility = View.VISIBLE
        binding.textViewBtn4.visibility = View.VISIBLE
    }

    private fun hideTextViews() {
        binding.textViewBtn1.visibility = View.INVISIBLE
        binding.textViewBtn2.visibility = View.INVISIBLE
        binding.textViewBtn3.visibility = View.INVISIBLE
        binding.textViewBtn4.visibility = View.INVISIBLE
    }

    private fun resetTextViewsAndCounters() {
        counter1PreviousValue = counter1
        counter1 = 0
        binding.textViewBtn1.text = counter1.toString()
        counter2PreviousValue = counter2
        counter2 = 0
        binding.textViewBtn2.text = counter2.toString()
        counter3PreviousValue = counter3
        counter3 = 0
        binding.textViewBtn3.text = counter3.toString()
        counter4PreviousValue = counter4
        counter4 = 0
        binding.textViewBtn4.text = counter4.toString()
    }

    private fun checkWin() {
        if(activePlayer == 0) {
            if(checkCounters()) {
                player2Score += currentLvl
                binding.textViewPlayer2.text = "Player 2: $player2Score"
                Toast.makeText(this, "Congratulations! Player 2 got it right.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Oops! Player 2 got it wrong.", Toast.LENGTH_SHORT).show()
            }
        } else {
            if(checkCounters()) {
                player1Score += currentLvl
                binding.textViewPlayer1.text = "Player 1: $player1Score"
                Toast.makeText(this, "Congratulations! Player 1 got it right.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Oops! Player 1 got it wrong.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkCounters(): Boolean {
        var correct = false
        if (counter1PreviousValue === counter1 && counter2PreviousValue === counter2 && counter3PreviousValue === counter3 && counter4PreviousValue === counter4) {
            correct = true
        }
        return correct
    }
}