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

    // 0: yellow, 1: red, 2: empty
    var gameState = intArrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)
    var winningPositions = arrayOf(
        intArrayOf(0, 1, 2),
        intArrayOf(3, 4, 5),
        intArrayOf(6, 7, 8),
        intArrayOf(0, 3, 6),
        intArrayOf(1, 4, 7),
        intArrayOf(2, 5, 8),
        intArrayOf(0, 4, 8),
        intArrayOf(2, 4, 6)
    )
    var activePlayer = 0
    var gameActive = true

    fun onDrawCircle(view: View) {
        val counter = view as ImageView
        val tappedCounter = counter.tag.toString().toInt()
        if (gameState[tappedCounter] == 2 && gameActive) {
            gameState[tappedCounter] = activePlayer
            counter.translationY = -1500f
            activePlayer = if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow)
                1
            } else {
                counter.setImageResource(R.drawable.red)
                0
            }
            counter.animate().translationYBy(1500f).rotation(3600f).duration = 300
            for (winningPosition in winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                    //Someone won
                    gameActive = false
                    var winner = ""
                    winner = if (activePlayer == 1) {
                        "Yellow"
                    } else {
                        "Red"
                    }
                    val playAgainButton = findViewById(R.id.playAgainButton) as Button
                    val winnerTextView = findViewById(R.id.winnerTextView) as TextView
                    winnerTextView.text = "$winner has won!"
                    playAgainButton.visibility = View.VISIBLE
                    winnerTextView.visibility = View.VISIBLE
                }
            }
            if(!gameState.contains(2)) {
                val playAgainButton = findViewById(R.id.playAgainButton) as Button
                playAgainButton.visibility = View.VISIBLE
            }
        }
    }

    fun restartGame(view: View?) {
        val playAgainButton = findViewById(R.id.playAgainButton) as Button
        val winnerTextView = findViewById(R.id.winnerTextView) as TextView
        playAgainButton.visibility = View.INVISIBLE
        winnerTextView.visibility = View.INVISIBLE
        val gridLayout = findViewById(R.id.gridLayout) as GridLayout
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

    protected override fun onCreate(savedInstanceState: Bundle?) {
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
        binding.playAgainButton.setOnClickListener {v -> restartGame(v)}
    }
}