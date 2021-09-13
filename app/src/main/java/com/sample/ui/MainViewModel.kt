package com.sample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sample.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {
    private val characterRepo = CharacterRepository()

    fun getCharacters() = liveData(Dispatchers.IO) {
        val result = characterRepo.getAllCharacters()
        emit(result)
    }
}