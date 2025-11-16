package com.example.modul4_tugas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CharacterAdapter(
    private val characters: List<Character>,
    private val onClick: (Character) -> Unit
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
        holder.itemView.setOnClickListener { onClick(character) }
    }

    override fun getItemCount(): Int = characters.size

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.character_name)
        private val bountyTextView: TextView = itemView.findViewById(R.id.character_bounty)
        private val photoImageView: ImageView = itemView.findViewById(R.id.character_photo)

        fun bind(character: Character) {
            nameTextView.text = character.name
            bountyTextView.text = "Bounty: ${character.bounty}"
            photoImageView.setImageResource(character.photo)
        }
    }
}
