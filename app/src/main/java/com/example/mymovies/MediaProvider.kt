package com.example.mymovies

import androidx.annotation.WorkerThread
import com.example.mymovies.MediaItem.*


object MediaProvider {
    @WorkerThread
    fun getItems(): List<MediaItem> {
        Thread.sleep(2000)
        return listOf(
            MediaItem(1,"title 1", "https://placekitten.com/200/200?image=1", Type.PHOTO),
            MediaItem(2,"title 2", "https://placekitten.com/200/200?image=2", Type.PHOTO),
            MediaItem(3,"title 3", "https://placekitten.com/200/200?image=3", Type.VIDEO),
            MediaItem(4,"title 4", "https://placekitten.com/200/200?image=4", Type.PHOTO),
            MediaItem(5,"title 5", "https://placekitten.com/200/200?image=5", Type.VIDEO),
            MediaItem(6,"title 6", "https://placekitten.com/200/200?image=6", Type.PHOTO),
            MediaItem(7,"title 7", "https://placekitten.com/200/200?image=7", Type.VIDEO),
            MediaItem(8,"title 8", "https://placekitten.com/200/200?image=8", Type.PHOTO),
            MediaItem(9,"title 9", "https://placekitten.com/200/200?image=9", Type.PHOTO),
            MediaItem(10,"title 10", "https://placekitten.com/200/200?image=10", Type.VIDEO)
        )
    }
}