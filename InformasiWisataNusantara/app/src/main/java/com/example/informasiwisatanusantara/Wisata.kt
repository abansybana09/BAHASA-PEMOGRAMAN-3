package com.example.informasiwisatanusantara

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Wisata(
    val name: String,
    val location: String,
    val ticketPrice: String,
    val rating: Float,
    val description: String,
    val operationalHours: String,
    val image: Int
) : Parcelable
