package com.example.informasiwisatanusantara

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_WISATA = "extra_wisata"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val wisata = intent.getParcelableExtra<Wisata>(EXTRA_WISATA)

        if (wisata != null) {
            val ivDetailWisata: ImageView = findViewById(R.id.iv_detail_wisata)
            val tvDetailNamaWisata: TextView = findViewById(R.id.tv_detail_nama_wisata)
            val tvDetailLokasi: TextView = findViewById(R.id.tv_detail_lokasi)
            val tvDetailTiket: TextView = findViewById(R.id.tv_detail_tiket)
            val tvDetailJam: TextView = findViewById(R.id.tv_detail_jam)
            val tvDetailRating: TextView = findViewById(R.id.tv_detail_rating)
            val tvDetailDeskripsi: TextView = findViewById(R.id.tv_detail_deskripsi)
            val fabShare: FloatingActionButton = findViewById(R.id.fab_share)

            ivDetailWisata.setImageResource(wisata.image)
            tvDetailNamaWisata.text = wisata.name
            tvDetailLokasi.text = wisata.location
            tvDetailTiket.text = wisata.ticketPrice
            tvDetailJam.text = wisata.operationalHours
            tvDetailRating.text = wisata.rating.toString()
            tvDetailDeskripsi.text = wisata.description

            fabShare.setOnClickListener {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Kunjungi ${wisata.name} di ${wisata.location}")
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }
    }
}