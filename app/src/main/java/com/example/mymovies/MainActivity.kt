package com.example.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.mymovies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val adapter: MediaAdapter by lazy { MediaAdapter(getItems()) { toast(it.title) } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        adapter.mediaItems = getItems().let { items ->
            when (item.itemId) {
                R.id.filter_all -> items
                R.id.filter_photos -> items.filter { it.type == MediaItem.Type.PHOTO }
                R.id.filter_videos -> items.filter { it.type == MediaItem.Type.VIDEO }
                else -> emptyList()
            }
        }
        return true
    }
}