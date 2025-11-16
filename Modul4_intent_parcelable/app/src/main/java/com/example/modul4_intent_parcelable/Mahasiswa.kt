package com.example.modul4_intent_parcelable

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mahasiswa(
    val name: String?,
    val email: String?,
    val nim: String?,
    val umur: Int?,
    val kota: String?
) : Parcelable
