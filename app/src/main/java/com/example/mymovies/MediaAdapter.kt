package com.example.mymovies

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymovies.MediaItem.*

class MediaAdapter(private val mediaItems: List<MediaItem>) : RecyclerView.Adapter<MediaAdapter.ViewHolder>() {


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

        private val title : TextView = view.findViewById(R.id.mediaTitle)
        private val thumb : ImageView = view.findViewById(R.id.mediaThumb)
        private val videoIndicator :ImageView = view.findViewById(R.id.mediaVideoIndicator)

        fun bind(mediaItem: MediaItem) {
            title.text = mediaItem.title
            thumb.loadUrl(mediaItem.url)

            videoIndicator.visibility = when (mediaItem.type) {
                Type.PHOTO -> View.GONE
                Type.VIDEO -> View.VISIBLE
            }

            itemView.setOnClickListener {

            }

        }

    }

}