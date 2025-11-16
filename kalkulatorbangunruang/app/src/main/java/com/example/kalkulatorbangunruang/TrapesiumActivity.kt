package com.example.kalkulatorbangunruang

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TrapesiumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_trapesium)

        val edtSisiAtas = findViewById<EditText>(R.id.edt_sisi_atas)
        val edtSisiBawah = findViewById<EditText>(R.id.edt_sisi_bawah)
        val edtTinggi = findViewById<EditText>(R.id.edt_tinggi)
        val btnHitung = findViewById<Button>(R.id.btn_hitung)
        val hasil = findViewById<TextView>(R.id.hasil)

        btnHitung.setOnClickListener {
            val sisiAtasValue = edtSisiAtas.text.toString().toDouble()
            val sisiBawahValue = edtSisiBawah.text.toString().toDouble()
            val tinggiValue = edtTinggi.text.toString().toDouble()
            val luas = 0.5 * (sisiAtasValue + sisiBawahValue) * tinggiValue
            hasil.text = luas.toString()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}