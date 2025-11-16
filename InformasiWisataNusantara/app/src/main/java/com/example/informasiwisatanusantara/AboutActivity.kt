package com.example.informasiwisatanusantara

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val btnBack: Button = findViewById(R.id.btn_back)
        btnBack.setOnClickListener {
            finish()
        }
    }
}
