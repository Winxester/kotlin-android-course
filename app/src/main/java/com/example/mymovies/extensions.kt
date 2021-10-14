package com.example.mymovies

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun ImageView.loadUrl(url: String) {
    Glide.with(this).load(url).into(this)
}

inline fun <reified T: Activity> Context.startActivity(vararg pairs: Pair<String, Any?>) {
    val bundle: Bundle = bundleOf(*pairs)
    val intent = Intent(this, T::class.java)
    intent.putExtras(bundle)
    startActivity(intent)
}