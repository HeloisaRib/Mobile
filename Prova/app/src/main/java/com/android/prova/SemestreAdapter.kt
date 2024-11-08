package com.android.prova

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class SemestreAdapter(private val context: Context, private val semestres: List<Semestre>?, private val onClickListener: SemestreOnClickListener) : RecyclerView.Adapter<SemestreAdapter.SemestresViewHolder>() {

    // Interface que define o comportamento de clique
    interface SemestreOnClickListener{
        fun onClickSemestre(holder: SemestresViewHolder?, idx: Int)
    }

    // Infla o layout e cria o ViewHolder
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SemestresViewHolder {
        // Este método cria uma subclasse de RecyclerView.ViewHolder
        // Infla a view do layout
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_semestre, viewGroup, false)
        // Cria a classe do ViewHolder
        return SemestresViewHolder(view)
    }

    // Retorna o tamanho da lista
    override fun getItemCount(): Int= semestres!!.size

    // Faz o binddas views no ViewHoldercom os dados da lista
    override fun onBindViewHolder(holder: SemestresViewHolder, position: Int) {
        // Este método recebe o índice do elemento, e atualiza as
        // viewsque estão dentro do ViewHolder
        val semestre = semestres!![position]
        // Atualizada os valores nas views
        val periodo: String = semestre.semestre + " " + semestre.ano
        holder.description.text = periodo
        // Clique no item
        holder.itemView.setOnClickListener {
        // Chama o listener para informar que clicou no Planeta
            onClickListener.onClickSemestre(holder, position)
        }
    }

    // Subclasse de RecyclerView.ViewHolder.
    // ViewHolderque guarda as referências das views do item
    class SemestresViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        // Cria as views para salvar no ViewHolder
        var description: TextView = view.findViewById(R.id.description)
    }

}