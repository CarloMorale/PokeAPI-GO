package com.example.pokeapigo.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.pokeapigo.R
import com.example.pokeapigo.core.Constants
import com.example.pokeapigo.databinding.ActivityMainBinding
import com.example.pokeapigo.viewmodels.PokemonViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[PokemonViewModel::class.java]
        var randomNumber = generateRandomNumber()


        // number
        viewModel.getPokemon(randomNumber)

        viewModel.pokemon.observe(this, Observer { pokemon ->
            binding.namePokemon.text = "#${pokemon.id} " + pokemon.name

            Glide.with(this)
                .load(Constants.BASE_URL_IMG + "${pokemon.id}.png")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.imgPokemon)
        })

        binding.getRandomPokemonButton.setOnClickListener {
            randomNumber = generateRandomNumber()
            viewModel.getPokemon(randomNumber)
        }
    }

    private fun generateRandomNumber(): Int {
        return(1..1008).random()
    }
}