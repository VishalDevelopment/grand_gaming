package com.example.grandgaming.UiLayer.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.grandgaming.DataLayer.Model.Cat
import com.example.grandgaming.UiLayer.Activities.MainActivity2
import com.example.grandgaming.databinding.ItemCatBinding

class CatAdapter : RecyclerView.Adapter<CatAdapter.CatViewHolder>() {

    private var cats = listOf<Cat>()

    fun setCats(list: List<Cat>) {
        cats = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val binding = ItemCatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val cat = cats[position]
        holder.bind(cat)

        holder.itemView.setOnClickListener {
            val context = it.context
            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra("cat_url", cat.url)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = cats.size

    class CatViewHolder(private val binding: ItemCatBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cat: Cat) {
            Glide.with(binding.imageView.context)
                .load(cat.url)
                .into(binding.imageView)
        }
    }
}

