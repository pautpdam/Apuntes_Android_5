package com.example.examenandroid_5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examenandroid_5.databinding.ItemVideogameBinding

class VideogameAdapter(private var listaJuegos: List<Videogame>, private var listener: OnClickListener): RecyclerView.Adapter<VideogameAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemVideogameBinding.bind(view)

        fun setListener(videogame: Videogame) {
            binding.root.setOnClickListener {
                listener.onClick(videogame)
            }
        }
    }

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_videogame, parent, false)
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = listaJuegos.get(position)
        with(holder) {
            setListener(food)
            binding.txtVideogameName.text = food.name
            binding.txtVideogameDetails.text = "${food.genre} - ${food.year}"
        }
    }

    override fun getItemCount(): Int = listaJuegos.size

}