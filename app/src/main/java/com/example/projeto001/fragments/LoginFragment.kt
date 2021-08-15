package com.example.projeto001.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.projeto001.R
import com.example.projeto001.model.User
import com.example.projeto001.service.RetrofitBuilder
import com.example.projeto001.utils.snackBar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment(R.layout.fragment_login), Callback<List<User>> {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var inEmail: EditText
    private val call by lazy {
        val service = RetrofitBuilder.userInstanceService()
        service.getUser()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inEmail = view.findViewById(R.id.editTextEmail)
        view.findViewById<Button>(R.id.botaoEntrar).apply {
            setOnClickListener { login() }
        }
    }

    private fun login() {
        call.clone().enqueue(this)
    }

    override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
        val user = response.body()?.let { listUsers ->
            listUsers.firstOrNull { inEmail.text.toString() == it.email }
        }
        if (user != null) {
            println("ok")
            replaceFragment(ListProductsFragment())
        } else {
            view?.let {
                snackBar(inEmail, R.string.error_message_auth)
            }
        }
    }

    override fun onFailure(call: Call<List<User>>, t: Throwable) {
        println("Falha na Request")
        view?.let {
            snackBar(inEmail, R.string.error_message_server)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container1, fragment)
            .commit()
    }

}
