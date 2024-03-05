package com.example.pokeapigo.network

import com.example.pokeapigo.models.PokemonModel
import com.example.pokeapigo.network.response.pokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {
    @GET("pokemon/{id}")
    suspend fun getPokemonId(@Path("id") id: Int): Response<PokemonModel>
}