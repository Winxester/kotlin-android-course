package com.example.mymovies

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymovies.MediaItem.*
import com.example.mymovies.databinding.ViewMediaItemBinding

class MediaAdapter(private val mediaItems: List<MediaItem>) :
    RecyclerView.Adapter<MediaAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.view_media_item)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mediaItems[position]

        holder.bind(item)

    }

    override fun getItemCount(): Int = mediaItems.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ViewMediaItemBinding.bind(view)

        fun bind(mediaItem: MediaItem) {
            binding.mediaTitle.text = mediaItem.title
            binding.mediaThumb.loadUrl(mediaItem.url)

            binding.mediaVideoIndicator.visibility = when (mediaItem.type) {
                Type.PHOTO -> View.GONE
                Type.VIDEO -> View.VISIBLE
            }

            binding.root.setOnClickListener {

            }

        }

    }

}