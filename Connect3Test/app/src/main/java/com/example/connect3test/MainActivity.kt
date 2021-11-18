package com.example.connect3test

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.connect3test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // 0 = yellow circle, 1 = red circle, 2 = empty space
    private var gameState = intArrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)
    private var winningPositions = arrayOf(
        intArrayOf(0, 3, 6),
        intArrayOf(1, 4, 7),
        intArrayOf(0, 4, 8),
        intArrayOf(2, 4, 6),
        intArrayOf(0, 1, 2),
        intArrayOf(3, 4, 5),
        intArrayOf(6, 7, 8),
        intArrayOf(2, 5, 8)
    )
    private var activePlayer = 0
    private var gameActive = true

    private fun onDrawCircle(view: View) {
        val counter = view as ImageView
        val tappedCounter = counter.tag.toString().toInt()
        if (gameState[tappedCounter] == 2 && gameActive) {
            gameState[tappedCounter] = activePlayer
            counter.translationY = -1500f
            activePlayer = if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow_circle)
                1
            } else {
                counter.setImageResource(R.drawable.red_circle)
                0
            }
            counter.animate().translationYBy(1500f).rotation(3600f).duration = 300
            for (winningPosition in winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                    //Someone has won
                    gameActive = false
                    val winner : String = if (activePlayer == 1) {
                        "Yellow"
                    } else {
                        "Red"
                    }
                    val playAgainButton = findViewById<Button>(R.id.playAgainButton)
                    val winnerTextView = findViewById<TextView>(R.id.winnerTextView)
                    "$winner is the winner!".also { winnerTextView.text = it }
                    playAgainButton.visibility = View.VISIBLE
                    winnerTextView.visibility = View.VISIBLE
                }
            }
            if(!gameState.contains(2)) {
                val playAgainButton = findViewById<Button>(R.id.playAgainButton)
                playAgainButton.visibility = View.VISIBLE
            }
        }
    }

    private fun restartGame() {
        val playAgainButton = findViewById<Button>(R.id.playAgainButton)
        val winnerTextView = findViewById<TextView>(R.id.winnerTextView)
        playAgainButton.visibility = View.INVISIBLE
        winnerTextView.visibility = View.INVISIBLE
        val gridLayout = findViewById<GridLayout>(R.id.gridLayout)
        for (i in 0 until gridLayout.childCount) {
            val counter = gridLayout.getChildAt(i) as ImageView
            counter.setImageDrawable(null)
        }
        for (i in gameState.indices) {
            gameState[i] = 2
        }
        activePlayer = 0
        gameActive = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.imageView1.setOnClickListener {v -> onDrawCircle(v)}
        binding.imageView2.setOnClickListener {v -> onDrawCircle(v)}
        binding.imageView3.setOnClickListener {v -> onDrawCircle(v)}
        binding.imageView4.setOnClickListener {v -> onDrawCircle(v)}
        binding.imageView5.setOnClickListener {v -> onDrawCircle(v)}
        binding.imageView6.setOnClickListener {v -> onDrawCircle(v)}
        binding.imageView7.setOnClickListener {v -> onDrawCircle(v)}
        binding.imageView8.setOnClickListener {v -> onDrawCircle(v)}
        binding.imageView9.setOnClickListener {v -> onDrawCircle(v)}
        binding.playAgainButton.setOnClickListener {restartGame()}
    }
}