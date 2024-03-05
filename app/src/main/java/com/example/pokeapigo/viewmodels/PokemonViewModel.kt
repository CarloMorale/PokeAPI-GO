package com.example.pokeapigo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokeapigo.models.PokemonModel
import com.example.pokeapigo.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonViewModel: ViewModel() {
    private var _pokemon = MutableLiveData<PokemonModel>()
    val pokemon: LiveData<PokemonModel> = _pokemon

    fun getPokemon(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.getPokemonId(id)
            withContext(Dispatchers.Main) {
                _pokemon.value = response.body()
            }
        }
    }
}