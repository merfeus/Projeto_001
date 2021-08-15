package com.example.projeto001.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projeto001.R
import com.example.projeto001.model.Clickbleitem
import com.example.projeto001.model.Products

class Adapter(var listOfProducts: List<Products>, val parametroIterface: Clickbleitem) :
    RecyclerView.Adapter<ProductViewHolder>() {

    //Define o layout para cada item da nossa lista. Link com o arquivo XML

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
            .apply {
                return ProductViewHolder(this)
            }
    }

    //Manipulamos os dados de cada item (tela x elemento + index)
    //Aqui que jogamos os dados para a tela, e add os eventos como o de click

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        listOfProducts[position].apply {
            holder.bengin(this)
            holder.itemView.setOnClickListener{
                //inplementado interface de clicks
                parametroIterface.onClickDetails(this)
            }
        }
    }

    //Define quantos elementos a o recycler view irá precisar criar

    override fun getItemCount(): Int = listOfProducts.size

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
