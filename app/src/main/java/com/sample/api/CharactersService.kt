package com.sample.api

import com.sample.model.CharactersResponse
import retrofit2.http.GET

interface CharactersService {
    @GET("character")
    suspend fun getAllCharacters(): CharactersResponse
}