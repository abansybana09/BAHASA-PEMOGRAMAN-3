package com.example.modul4_tugas

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val name: String,
    val bounty: Long,
    val devilFruit: String?,
    val photo: Int
) : Parcelable
