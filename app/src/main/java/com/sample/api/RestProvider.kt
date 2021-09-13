package com.sample.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//FIXME replace with DI
object RestProvider {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val charactersService: CharactersService = retrofit.create(CharactersService::class.java)
}