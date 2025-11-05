package com.example.modul3_activity2

import android.content.Intent // <-- Tambahkan import ini
import android.os.Bundle
import android.widget.Button // <-- Tambahkan import ini
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class halaman_selanjutnya : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_halaman_selanjutnya)
        //inisiasikan button ke variabel
        val btn_pindah = findViewById<Button>(R.id.btn_pindah_halaman1)
        ////aksi ketika button diklik
        btn_pindah.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
