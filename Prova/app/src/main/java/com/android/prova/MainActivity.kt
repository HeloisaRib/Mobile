package com.android.prova

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var semestres: List<Semestre>? = emptyList()
    private lateinit var adapter: SemestreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ação para exibir o botão de voltar na ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // Configura o RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator= DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)
        // Obtenha a lista de planetas
        semestres = Semestre.SemestresData.getSemestres()
        // Configura o Adaptere o click listener
        adapter = SemestreAdapter(this, semestres, onClickSemestre())
        recyclerView.adapter = adapter
    }

    // Função que retorna o listener para os clicks nos planetas
    private fun onClickSemestre(): SemestreAdapter.SemestreOnClickListener {
        return object : SemestreAdapter.SemestreOnClickListener {
            override fun onClickSemestre(holder: SemestreAdapter.SemestresViewHolder?, idx: Int) {
                val semestre = semestres?.getOrNull(idx) ?: return

                val cpfView    = findViewById<EditText>(R.id.inputCPF)
                val cpf        = cpfView.text.toString()

                val valorView    = findViewById<EditText>(R.id.input_valor_para_saque)
                val valor        = valorView.text.toString()

                var valorSaque: Float = valor.toFloat()
                if (semestre.ano.toInt() > 2020)
                    valorSaque -= (valorSaque * semestre.ano[3].digitToInt().toFloat() / 10) //calcula a porcetagem de acordo com o ano

                val intent = Intent(baseContext, PeriodoActivity::class.java)
                intent.putExtra("cpf", cpf)
                intent.putExtra("valor para saque", valorSaque)
                startActivity(intent)

        }
    }
}
}