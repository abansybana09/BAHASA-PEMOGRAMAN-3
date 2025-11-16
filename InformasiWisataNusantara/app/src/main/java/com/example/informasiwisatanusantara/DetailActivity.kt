package com.example.informasiwisatanusantara

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.WindowCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_WISATA = "extra_wisata"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Let the system handle window insets automatically.
        // This guarantees that the layout will not be drawn behind the system bars.
        // This is a simpler and more robust solution to the spacing problem.
        WindowCompat.setDecorFitsSystemWindows(window, true)
        setContentView(R.layout.activity_detail)

        val toolbar: Toolbar = findViewById(R.id.toolbar_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val wisata = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_WISATA, Wisata::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_WISATA)
        }

        if (wisata != null) {
            populateWisataDetails(wisata)
        }
    }

    private fun populateWisataDetails(wisata: Wisata) {
        supportActionBar?.title = wisata.name

        val ivDetailWisata: ImageView = findViewById(R.id.iv_detail_wisata)
        val tvDetailNamaWisata: TextView = findViewById(R.id.tv_detail_nama_wisata)
        val tvDetailLokasi: TextView = findViewById(R.id.tv_detail_lokasi)
        val tvDetailTiket: TextView = findViewById(R.id.tv_detail_tiket)
        val tvDetailJam: TextView = findViewById(R.id.tv_detail_jam)
        val tvDetailRating: TextView = findViewById(R.id.tv_detail_rating)
        val tvDetailDeskripsi: TextView = findViewById(R.id.tv_detail_deskripsi)

        ivDetailWisata.setImageResource(wisata.image)
        tvDetailNamaWisata.text = wisata.name
        tvDetailLokasi.text = wisata.location
        tvDetailTiket.text = wisata.ticketPrice
        tvDetailJam.text = wisata.operationalHours
        tvDetailRating.text = wisata.rating.toString()
        tvDetailDeskripsi.text = wisata.description

        findViewById<FloatingActionButton>(R.id.fab_share).setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Kunjungi ${wisata.name} di ${wisata.location}")
                type = "text/plain"
            }
            startActivity(Intent.createChooser(sendIntent, null))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressedDispatcher.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}