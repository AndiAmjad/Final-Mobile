package com.d121211064.mycat.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.d121211064.mycat.data.model.CatImage
import com.d121211064.mycat.databinding.ItemCatBinding

class MainAdapter(private val catImages: List<CatImage>, private val viewModel: MainViewModel) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val catImage = catImages[position]
        holder.binding.imageView // Gunakan binding untuk mengakses elemen UI
        holder.binding.root.setOnClickListener {
            viewModel.selectImage(catImage.url)
        }
    }

    override fun getItemCount(): Int {
        return catImages.size
    }

    class ViewHolder(val binding: ItemCatBinding) : RecyclerView.ViewHolder(binding.root)
}
