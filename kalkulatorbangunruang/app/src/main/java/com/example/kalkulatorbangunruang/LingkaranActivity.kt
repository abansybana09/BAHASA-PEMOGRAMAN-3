package com.example.kalkulatorbangunruang

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LingkaranActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lingkaran)

        val jariJari = findViewById<EditText>(R.id.edt_jari_jari)
        val btnHitung = findViewById<Button>(R.id.button)
        val hasil = findViewById<TextView>(R.id.hasil)

        btnHitung.setOnClickListener {
            val jariJariValue = jariJari.text.toString().toDouble()
            val luas = Math.PI * jariJariValue * jariJariValue
            hasil.text = luas.toString()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}