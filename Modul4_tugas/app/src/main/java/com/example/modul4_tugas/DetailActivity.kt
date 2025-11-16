package com.example.modul4_tugas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

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
        }
    }
}
