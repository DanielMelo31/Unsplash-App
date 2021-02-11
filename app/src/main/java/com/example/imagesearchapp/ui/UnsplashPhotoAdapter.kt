package com.example.imagesearchapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.imagesearchapp.R
import com.example.imagesearchapp.data.model.UnsplashPhoto
import com.example.imagesearchapp.databinding.ItemUnsplashPhotoBinding

class UnsplashPhotoAdapter :
    PagingDataAdapter<UnsplashPhoto, UnsplashPhotoAdapter.PhotoViewHolder>(PHOTO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val layoutBinding =
            ItemUnsplashPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(layoutBinding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    //ViewHolder
    class PhotoViewHolder(private val binding: ItemUnsplashPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: UnsplashPhoto) {
            binding.apply {
                Glide.with(itemView)
                    .load(item.urls.regular)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_error)
                    .into(futurePicture)

                tvUsername.text = item.user.username
            }
        }
    }

        companion object {
            private val PHOTO_COMPARATOR = object :
                DiffUtil.ItemCallback<UnsplashPhoto>() {
                override fun areItemsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto) =
                    oldItem.id == newItem.id

                override fun areContentsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto) =
                    oldItem == newItem

            }
        }
    }