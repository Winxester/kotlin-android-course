package com.example.mymovies

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mymovies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val adapter: MediaAdapter by lazy { MediaAdapter(getItems()) { toast(it.title) } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = adapter

        adapter.mediaItems = getItems()



    }
}