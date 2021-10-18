package com.example.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mymovies.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "DetailActivity:id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //intent.getIntExtra(EXTRA_ID,)

        // Ver vídeo para realizar ejercicio

    }
}