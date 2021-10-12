package com.example.mymovies

data class MediaItem (val title: String, val url: String, val type: Type) {
    enum class Type { PHOTO, VIDEO}
}