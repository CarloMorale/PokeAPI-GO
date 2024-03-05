package com.example.pokeapigo.network.response

import com.example.pokeapigo.models.PokemonModel

data class pokemonResponse(
    var results: List<PokemonModel>
)
