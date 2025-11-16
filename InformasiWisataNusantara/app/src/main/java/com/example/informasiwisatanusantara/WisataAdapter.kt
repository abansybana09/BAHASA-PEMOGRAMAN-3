package com.example.informasiwisatanusantara

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WisataAdapter(private val listWisata: ArrayList<Wisata>) : RecyclerView.Adapter<WisataAdapter.WisataViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WisataViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_wisata, parent, false)
        return WisataViewHolder(view)
    }

    override fun onBindViewHolder(holder: WisataViewHolder, position: Int) {
        val wisata = listWisata[position]
        holder.imgPhoto.setImageResource(wisata.image)
        holder.tvName.text = wisata.name
        holder.tvLocation.text = wisata.location
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listWisata[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listWisata.size

    class WisataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.iv_wisata)
        var tvName: TextView = itemView.findViewById(R.id.tv_nama_wisata)
        var tvLocation: TextView = itemView.findViewById(R.id.tv_lokasi)
    }

    fun interface OnItemClickCallback {
        fun onItemClicked(data: Wisata)
    }
}