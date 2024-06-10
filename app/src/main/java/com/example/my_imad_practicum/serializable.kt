package com.example.my_imad_practicum

import java.io.Serializable

data class ScreenDataEntry (
    val day: String,
    val min: Int,
    val max: Int,
    val weatherConditions: String
) : Serializable