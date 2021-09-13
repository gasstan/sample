package com.sample.model

data class Info(
    val count: String,
    val pages: Int,
    val next: String,
    val prev: String
)

data class CharactersResponse(
    val info: Info,
    val results : List<Character>
)
