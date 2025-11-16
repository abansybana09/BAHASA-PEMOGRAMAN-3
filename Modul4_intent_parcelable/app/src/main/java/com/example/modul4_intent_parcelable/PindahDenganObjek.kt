package com.example.modul4_intent_parcelable

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.modul4_intent_parcelable.R
import com.example.modul4_intent_parcelable.Mahasiswa

class PindahDenganObjek : AppCompatActivity() {

    companion object {
        const val EXTRA_MAHASISWA = "extra_mahasiswa"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindah_dengan_objek)

        val tvNama: TextView = findViewById(R.id.tv_object_nama)
        val tvNim: TextView = findViewById(R.id.tv_object_nim)
        val tvEmail: TextView = findViewById(R.id.tv_object_email)
        val tvKota: TextView = findViewById(R.id.tv_object_kota)
        val tvUmur: TextView = findViewById(R.id.tv_object_usia)

        val mahasiswa = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_MAHASISWA, Mahasiswa::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Mahasiswa>(EXTRA_MAHASISWA)
        }

        if (mahasiswa != null) {
            tvNama.text = "Nama: ${mahasiswa.name}"
            tvEmail.text = "Email: ${mahasiswa.email}"
            tvNim.text = "NIM: ${mahasiswa.nim}"
            tvUmur.text = "Umur: ${mahasiswa.umur.toString()}"
            tvKota.text = "Kota: ${mahasiswa.kota}"
        }
    }
}