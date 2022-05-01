package com.eddieshin.androidfundamentals

import java.io.Serializable

data class Person (
    val name: String,
    val age: Int,
    val origin: String
    ) : Serializable