package com.android.cronometro

import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val handler     = Handler()
    private var isRunning   = false
    private var seconds     = 0

    private lateinit var runnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        runnable = object : Runnable {
            override fun run() {
                if (isRunning) {
                    seconds++
                    runTimer()

                    handler.postDelayed(this, 1000) // Executa a cada 1 segundo
                }
            }
        }

        val startButton: Button = findViewById(R.id.startButton)
        val stopButton: Button  = findViewById(R.id.stopButton)
        val resetButton: Button = findViewById(R.id.resetButton)

        startButton.setOnClickListener {
            onClickStart()
        }

        stopButton.setOnClickListener {
            onClickStop()
        }

        resetButton.setOnClickListener {
            onClickReset()
        }
    }

    fun onClickStart() {
        isRunning = true
        handler.post(runnable)
    }

    fun onClickStop() {
        isRunning = false
        handler.removeCallbacks(runnable)
    }

    fun onClickReset() {
        isRunning   = false
        seconds     = 0
        runTimer()
        handler.removeCallbacks(runnable)
    }

    fun runTimer() {
        val timer: TextView = findViewById(R.id.timerView)
        val hours       = seconds / 3600
        val minutes     = (seconds % 3600) / 60
        val secs        = seconds % 60
        timer.text      = String.format("%02d:%02d:%02d", hours, minutes, secs)
    }
}