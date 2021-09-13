package com.sample.model

import java.io.Serializable

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: NameUrl,
    val location: NameUrl,
    val image: String
) : Serializable

data class NameUrl(
    val name : String,
    val url : String
)