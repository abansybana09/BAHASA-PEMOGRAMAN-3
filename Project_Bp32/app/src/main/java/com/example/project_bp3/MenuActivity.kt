package com.example.project_bp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
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
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val beforeWudhuButton = findViewById<ImageButton>(R.id.before_wudhu_button)
        val learnWudhuButton = findViewById<ImageButton>(R.id.learn_wudhu_button)
        val afterWudhuButton = findViewById<ImageButton>(R.id.after_wudhu_button)
        val panduanButton = findViewById<ImageView>(R.id.panduan_button) // Assuming you changed the id in xml

        beforeWudhuButton.setOnClickListener {
            val intent = Intent(this, SebelumWudhuActivity::class.java)
            startActivity(intent)
        }

        afterWudhuButton.setOnClickListener {
            val intent = Intent(this, SesudahWudhuActivity::class.java)
            startActivity(intent)
        }

        learnWudhuButton.setOnClickListener {
            val intent = Intent(this, BelajarWudhuActivity::class.java)
            startActivity(intent)
        }

        panduanButton.setOnClickListener {
            val intent = Intent(this, PanduanWudhuActivity::class.java)
            startActivity(intent)
        }
    }
}
