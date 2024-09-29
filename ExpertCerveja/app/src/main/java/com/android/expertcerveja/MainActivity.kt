package com.android.expertcerveja

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.expertcerveja.ExpertCerveja.Companion.GetCervejasPorTipo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val spinner: Spinner        = findViewById((R.id.spinner))
        val textView: TextView      = findViewById(R.id.strCervejasEncontradas)
        val button: Button          = findViewById(R.id.btBuscar)

        button.setOnClickListener {
            val selectedItem        = spinner.selectedItem as String
            val cervejas            = GetCervejasPorTipo(selectedItem, this)
            textView.text           = cervejas
            textView.visibility     = TextView.VISIBLE
        }
    }
}