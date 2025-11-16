package com.example.modul4_tugas

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val characters = listOf(
            Character("Monkey D. Luffy", 3000000000, "Gomu Gomu no Mi", R.drawable.luffy),
            Character("Roronoa Zoro", 1111000000, null, R.drawable.zoro),
            Character("Nami", 366000000, null, R.drawable.nami),
            Character("Usopp", 500000000, null, R.drawable.usopp),
            Character("Sanji", 1032000000, null, R.drawable.sanji),
            Character("Tony Tony Chopper", 1000, "Hito Hito no Mi", R.drawable.chopper),
            Character("Nico Robin", 930000000, "Hana Hana no Mi", R.drawable.robin),
            Character("Franky", 394000000, null, R.drawable.franky),
            Character("Brook", 383000000, "Yomi Yomi no Mi", R.drawable.brook),
            Character("Jinbe", 1100000000, null, R.drawable.jinbe)
        )

        adapter = CharacterAdapter(characters) { character ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("character", character)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }
}
