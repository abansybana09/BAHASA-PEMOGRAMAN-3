package com.example.project_bp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val username = intent.getStringExtra("USERNAME")
        val usernameTextView = findViewById<TextView>(R.id.username_textview)
        usernameTextView.text = username

        val exitButton = findViewById<ImageButton>(R.id.exit_button)
        exitButton.setOnClickListener {
            finish()
        }

        val beforeWudhuButton = findViewById<ImageButton>(R.id.before_wudhu_button)
        val learnWudhuButton = findViewById<ImageButton>(R.id.learn_wudhu_button)
        val afterWudhuButton = findViewById<ImageButton>(R.id.after_wudhu_button)

        // Menambahkan listener untuk tombol "Do'a Sesudah Wudhu"


        // TODO: Anda bisa menambahkan listener untuk dua tombol lainnya di sini
        // Contoh untuk tombol "Belajar Wudhu":
        // learnWudhuButton.setOnClickListener {
        //     val intent = Intent(this, BelajarWudhuActivity::class.java)
        //     startActivity(intent)
        // }
    }
}