package com.example.projeto001.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.projeto001.R
import com.example.projeto001.fragments.LoginFragment
import com.example.projeto001.model.Products

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(LoginFragment.newInstance())
    }

    //Chama Fragment

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container1, fragment)
            .commitNow()
    }

    //Chamando interface de clicks, passando como parametro Products e fazendo o putExtra para
    // receber o id do produto

    fun chengeScreen(products: Products) {
        Intent(this, DetailsActivity::class.java).apply {
            putExtra("key_product", products.id)
            startActivity(this)
        }

    }

}