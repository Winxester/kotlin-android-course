package com.example.mymovies

import com.example.mymovies.MediaItem.*


fun getItems(): List<MediaItem> = listOf(1..10).map {
    MediaItem(
        "Title $it",
        "https://placekitten.com/200/200?image=$it",
        if (it % 3 == 0) Type.VIDEO else Type.PHOTO
    )
}
