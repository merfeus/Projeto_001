package com.example.projeto001.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.projeto001.R
import com.example.projeto001.fragments.PrimeiroFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(PrimeiroFragment.newInstance())
    }

    //Chama Fragment

    fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container1, fragment)
            .commitNow()
    }

    //Chamando Intent de Detalhes

    fun chenceScreen(){
        val intentDetailsActivity = Intent(this, DetailsActivity::class.java)
        startActivity(intentDetailsActivity)
    }

}