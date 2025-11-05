package com.example.project_bp3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val backgroundImageView = findViewById<ImageView>(R.id.background_image)
        Glide.with(this).load(R.drawable.bg1).into(backgroundImageView)

        val mulaiButton = findViewById<Button>(R.id.rudkemul8jcl)
        mulaiButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}