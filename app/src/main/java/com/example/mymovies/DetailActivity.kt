package com.example.mymovies

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.mymovies.MediaItem.*
import com.example.mymovies.databinding.ActivityDetailBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "DetailActivity:id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemId = intent.getIntExtra(EXTRA_ID, -1)

        lifecycleScope.launch {
            val items = withContext(Dispatchers.IO) { MediaProvider.getItems() }
            val item : MediaItem? = items.firstOrNull { it.id == itemId}

            item?.let {
                supportActionBar?.title = item.title
                binding.detailThumb.loadUrl(item.url)
                binding.detailVideoIndicator.visibility = when (item.type) {
                    Type.VIDEO -> View.VISIBLE
                    Type.PHOTO -> View.GONE
                }
            }
        }
    }
}