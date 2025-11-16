package com.example.modul4_tugas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detail_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val character = intent.getParcelableExtra<Character>("character")

        if (character != null) {
            findViewById<TextView>(R.id.detail_name).text = character.name
            findViewById<TextView>(R.id.detail_bounty).text = "Bounty: ${character.bounty}"
            findViewById<TextView>(R.id.detail_devil_fruit).text = "Devil Fruit: ${character.devilFruit ?: "-"}"
            findViewById<ImageView>(R.id.detail_photo).setImageResource(character.photo)

            val searchButton = findViewById<Button>(R.id.search_button)
            searchButton.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=${character.name}"))
                startActivity(intent)
            }

            val shareButton = findViewById<Button>(R.id.share_button)
            shareButton.setOnClickListener {
                val shareText = "Name: ${character.name}\nBounty: ${character.bounty}\nDevil Fruit: ${character.devilFruit ?: "-"}"
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareText)
                startActivity(Intent.createChooser(shareIntent, "Share via"))
            }
        }
    }
}
