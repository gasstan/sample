package com.sample.repository

import com.sample.api.RestProvider
import com.sample.model.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class CharacterRepository(
    private val coroutineContext: CoroutineContext = Dispatchers.IO
) {

    suspend fun getAllCharacters(): List<Character> =
        withContext(this@CharacterRepository.coroutineContext) {
            RestProvider.charactersService.getAllCharacters().results
        }
}