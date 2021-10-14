package com.example.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Filter
import android.widget.ProgressBar
import androidx.lifecycle.lifecycleScope
import com.example.mymovies.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {

    private val adapter = MediaAdapter { toast(it.title) }

    private lateinit var progress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = adapter
        progress = binding.progress

        updateItems()

    }

    private fun updateItems(filter: Int = R.id.filter_all) {
        lifecycleScope.launch {
            progress.visibility = View.VISIBLE
            adapter.mediaItems = withContext(Dispatchers.IO) { getFilteredItems(filter) }
            progress.visibility = View.GONE
        }
    }

    private fun getFilteredItems(filter: Int): List<MediaItem> {
        return MediaProvider.getItems().let { items ->
            when (filter) {
                R.id.filter_all -> items
                R.id.filter_photos -> items.filter { it.type == MediaItem.Type.PHOTO }
                R.id.filter_videos -> items.filter { it.type == MediaItem.Type.VIDEO }
                else -> emptyList()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        updateItems(item.itemId)
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}