package com.example.chi_internship_android_junior_myslyva

import java.io.Serializable

data class User(
    val name: String,
    val age: Int,
    var isStudent: Boolean = false
) : Serializable
