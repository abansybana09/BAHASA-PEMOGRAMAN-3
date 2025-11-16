package com.example.informasiwisatanusantara

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvWisata: RecyclerView
    private val list = ArrayList<Wisata>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_main)

        val ivAbout: ImageView = findViewById(R.id.iv_about)
        ivAbout.setOnClickListener {
            val intent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(intent)
        }

        rvWisata = findViewById(R.id.rv_wisata)
        rvWisata.setHasFixedSize(true)

        list.addAll(getListWisata())
        showRecyclerList()
    }

    private fun getListWisata(): List<Wisata> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataLocation = resources.getStringArray(R.array.data_location)
        val dataTicketPrice = resources.getStringArray(R.array.data_ticket_price)
        val dataRating = resources.getStringArray(R.array.data_rating)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataOperationalHours = resources.getStringArray(R.array.data_operational_hours)
        val dataImage = resources.obtainTypedArray(R.array.data_image)

        val listWisata = dataName.indices.map {
            Wisata(
                dataName[it],
                dataLocation[it],
                dataTicketPrice[it],
                dataRating[it].toFloat(),
                dataDescription[it],
                dataOperationalHours[it],
                dataImage.getResourceId(it, -1)
            )
        }
        dataImage.recycle()
        return listWisata
    }

    private fun showRecyclerList() {
        rvWisata.layoutManager = LinearLayoutManager(this)
        val wisataAdapter = WisataAdapter(list)
        rvWisata.adapter = wisataAdapter

        wisataAdapter.setOnItemClickCallback { data ->
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_WISATA, data)
            startActivity(intent)
        }
    }
}