package com.android.prova

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PeriodoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_periodo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intent     = intent
        val cpf        = intent.getStringExtra("cpf")
        val cpfView    = findViewById<TextView>(R.id.inputCPF)
        cpfView.text   = cpf

        val valor        = intent.getFloatExtra("valor para saque", 0f)
        val valorView    = findViewById<TextView>(R.id.input_valor_calculado)
        valorView.text   = valor.toString()

    }
}