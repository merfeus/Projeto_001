package com.example.projeto001.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.projeto001.R
import com.example.projeto001.model.Clickbleitem
import com.example.projeto001.model.Products
import com.example.projeto001.service.RetrofitBuilder
import com.example.projeto001.utils.snackBarAcivity
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsActivity : AppCompatActivity(), Callback<Products>{

    private lateinit var productImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var subtitleTextView: TextView
    private lateinit var priceTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        loadComponents()

    }

    private fun loadComponents() {

        productImageView = findViewById(R.id.productImageView)
        titleTextView = findViewById(R.id.titleTextView)
        subtitleTextView = findViewById(R.id.subtitleTextView)
        priceTextView = findViewById(R.id.priceTextView)
    }

    fun bind(productResponse: Products) {

        titleTextView.text = productResponse.title
        subtitleTextView.text = productResponse.description
        priceTextView.text = "R$ ${productResponse.price}"

        Glide.with(this)
            .load(productResponse.image)
            .placeholder(R.drawable.ic_baseline_hide_image_24)
            .into(productImageView)
    }


    override fun onResponse(call: Call<Products>, response: Response<Products>) {
        response.body()?.apply {
            bind(this)
        }
    }

    override fun onFailure(call: Call<Products>, t: Throwable) {
        snackBarAcivity(titleTextView, R.string.error_message_server)
    }


}