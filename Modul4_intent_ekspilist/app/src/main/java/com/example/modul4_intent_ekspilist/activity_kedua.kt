package com.example.modul4_intent_ekspilist

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.modul4_intent_ekspilist.R

class ActivityKedua : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kedua)

        val extras = intent.extras
        val kampus = extras?.getString("Kampus")
        val fakultas = extras?.getString("Fakultas")
        val prodi = extras?.getString("Prodi")
        val matkul = extras?.getString("Matkul")
        val tv_kampus = findViewById<TextView>(R.id.univ)
        val tv_fakultas = findViewById<TextView>(R.id.fakultas)
        val tv_prodi = findViewById<TextView>(R.id.prodi)
        val tv_matkul = findViewById<TextView>(R.id.matkul)

        tv_kampus.text = kampus
        tv_fakultas.text = fakultas
        tv_prodi.text = prodi
        tv_matkul.text = matkul

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
