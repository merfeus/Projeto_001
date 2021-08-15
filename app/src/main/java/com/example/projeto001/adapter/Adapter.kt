package com.example.projeto001.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projeto001.R
import com.example.projeto001.model.Products

class Adapter(var listOfProducts: List<Products>) :
    RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
            .apply {
                return ProductViewHolder(this)
            }
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        listOfProducts[position].apply {
            holder.bengin(this)
        }
    }

    override fun getItemCount(): Int = listOfProducts.size

//    fun update(newList: List<Products>) {
//        listOfProducts = listOf()
//        listOfProducts.addAll(newList)
//        notifyDataSetChanged()
//    }
}

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val productImageView: ImageView = itemView.findViewById(R.id.productImageView)
    private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
    private val subtitleTextView: TextView = itemView.findViewById(R.id.subtitleTextView)
    private val priceTextView: TextView = itemView.findViewById(R.id.priceTextView)

    fun bengin(productResponse: Products) {

        titleTextView.text = productResponse.title
        subtitleTextView.text = productResponse.description
        priceTextView.text = "R$ ${productResponse.price}"

        Glide.with(itemView.context)
            .load(productResponse.image)
            .placeholder(R.drawable.ic_baseline_hide_image_24)
            .into(productImageView)

    }

}
