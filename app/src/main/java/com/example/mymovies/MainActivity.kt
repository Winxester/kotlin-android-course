package com.example.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.lifecycleScope
import com.example.mymovies.MediaItem.*
import com.example.mymovies.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val adapter = MediaAdapter {
        startActivity<DetailActivity>(DetailActivity.EXTRA_ID to it.id)
    }

    private lateinit var progress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = adapter
        progress = binding.progress

        updateItems()

    }

    private fun updateItems(filter: Filter = Filter.None) {
        lifecycleScope.launch {
            progress.visibility = View.VISIBLE
            adapter.mediaItems = withContext(Dispatchers.IO) { getFilteredItems(filter) }
            progress.visibility = View.GONE
        }
    }

    private fun getFilteredItems(filter: Filter): List<MediaItem> {
        return MediaProvider.getItems().let { items ->
            when (filter) {
                Filter.None -> items
                is Filter.ByType -> items.filter { it.type == filter.type }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val filter = when (item.itemId) {
            R.id.filter_photos -> Filter.ByType(Type.PHOTO)
            R.id.filter_videos -> Filter.ByType(Type.VIDEO)
            else -> Filter.None
        }

        updateItems(filter)
        return true
    }

}