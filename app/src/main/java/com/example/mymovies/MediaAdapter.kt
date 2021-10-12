package com.example.mymovies

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovies.MediaItem.*
import com.example.mymovies.databinding.ViewMediaItemBinding
import kotlin.properties.Delegates

class MediaAdapter(mediaItems: List<MediaItem> = emptyList(), private val listener: (MediaItem) -> Unit) :
    RecyclerView.Adapter<MediaAdapter.ViewHolder>() {

    var mediaItems: List<MediaItem> by Delegates.observable(mediaItems) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.view_media_item)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mediaItems[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item) }
    }

    override fun getItemCount(): Int = mediaItems.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ViewMediaItemBinding.bind(view)

        fun bind(mediaItem: MediaItem) {

            with(binding) {
                mediaTitle.text = mediaItem.title
                mediaThumb.loadUrl(mediaItem.url)

                mediaVideoIndicator.visibility = when (mediaItem.type) {
                    Type.PHOTO -> View.GONE
                    Type.VIDEO -> View.VISIBLE
                }
            }
        }

    }

}