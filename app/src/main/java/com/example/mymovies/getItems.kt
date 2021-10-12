package com.example.mymovies

import com.example.mymovies.MediaItem.*


object MediaProvider {
    fun getItems(): List<MediaItem> = listOf(
        MediaItem("title 1", "https://placekitten.com/200/200?image=1", Type.PHOTO),
        MediaItem("title 2", "https://placekitten.com/200/200?image=2", Type.PHOTO),
        MediaItem("title 3", "https://placekitten.com/200/200?image=3", Type.VIDEO),
        MediaItem("title 4", "https://placekitten.com/200/200?image=4", Type.PHOTO),
        MediaItem("title 5", "https://placekitten.com/200/200?image=5", Type.VIDEO),
        MediaItem("title 6", "https://placekitten.com/200/200?image=6", Type.PHOTO),
        MediaItem("title 7", "https://placekitten.com/200/200?image=7", Type.VIDEO),
        MediaItem("title 8", "https://placekitten.com/200/200?image=8", Type.PHOTO),
        MediaItem("title 9", "https://placekitten.com/200/200?image=9", Type.PHOTO),
        MediaItem("title 10", "https://placekitten.com/200/200?image=10", Type.VIDEO)
    )
}