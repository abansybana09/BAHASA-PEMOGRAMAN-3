package com.example.modul3_activity2

import android.content.Intent
import android.os.Bundle
import android.widget.Button // <-- Add this import statement
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //inisiasikan button ke variabel
        val btn_pindah = findViewById<Button>(R.id.btn_pindah_halaman2)
        //aksi ketika button diklik
        btn_pindah.setOnClickListener {
            // It seems you might have a class named 'halaman_selanjutnya'.
            // Make sure that class exists.
            val intent = Intent(this, halaman_selanjutnya::class.java)
            startActivity(intent)
        }
    }
}
