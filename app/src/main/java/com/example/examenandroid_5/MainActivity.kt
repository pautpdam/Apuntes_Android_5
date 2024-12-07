package com.example.examenandroid_5

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examenandroid_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var videogameAdapter: VideogameAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var itemDecoration: DividerItemDecoration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        videogameAdapter = VideogameAdapter(getVideogames(), this)
        linearLayoutManager = LinearLayoutManager(this)
        itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = videogameAdapter
            addItemDecoration(itemDecoration)
        }
    }

    private fun getVideogames() : MutableList<Videogame> {
        val videogames = mutableListOf<Videogame>()

        val minecraft = Videogame("Minecraft", 2009, "Sandbox")
        val lol = Videogame("League of Legends", 2009, "Estrategia Multijugador")
        val blasphemous = Videogame("Blasphemous", 2019, "Metroidvania")

        videogames.add(minecraft)
        videogames.add(lol)
        videogames.add(blasphemous)

        return videogames
    }

    override fun onClick(videogame: Videogame) {
        Toast.makeText(this, "Has seleccionado ${videogame.name}", Toast.LENGTH_SHORT).show()
    }
}