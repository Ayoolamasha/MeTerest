package com.ayoolamasha.meterest.ui.adapterPackage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ayoolamasha.meterest.databinding.HomeRecyclerDesignBinding
import com.ayoolamasha.meterest.domain.PhotoUICase

class PhotoAdapter : ListAdapter<PhotoUICase, PhotoAdapter.PhotoViewHolder>(PhotoDiffCallBack){


    inner class PhotoViewHolder(private val binding: HomeRecyclerDesignBinding): RecyclerView.ViewHolder(binding.root) {
        fun binds(items:PhotoUICase){
            binding.apply {
                photoUICase= items
                executePendingBindings()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            HomeRecyclerDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photosUICase = getItem(position)
        holder.binds(photosUICase)
    }

    object PhotoDiffCallBack: DiffUtil.ItemCallback<PhotoUICase>(){

        override fun areContentsTheSame(oldItem: PhotoUICase, newItem: PhotoUICase): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: PhotoUICase, newItem: PhotoUICase): Boolean {
            return oldItem.photoIdUiCase == newItem.photoIdUiCase
        }
    }

}