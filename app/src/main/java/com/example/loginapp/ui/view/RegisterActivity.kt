package com.example.loginapp.ui.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.loginapp.R
import com.example.loginapp.databinding.ActivityRegisterBinding
import com.example.loginapp.ui.viewmodel.RegisterViewModel
import com.example.loginapp.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel:RegisterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initObservers()
        initListeners()
    }

    private fun initObservers() {
        viewModel.registerState.observe(this){ state ->
            when(state){
                is Resource.Success -> {
                    handleLoading(false)
                    toast("Register success")
                }
                is Resource.Error -> {
                    handleLoading(false)
                    toast(state.message)
                }
                is Resource.loading -> handleLoading(true)
                else -> Unit
            }
        }
    }

    private fun initListeners() {
        with(binding){
            btnRegister.setOnClickListener {
                handleRegister()
            }
        }
    }

    private fun handleLoading(isLoading:Boolean){
        with(binding){
            if(isLoading){
                btnRegister.text = ""
                btnRegister.isEnabled = false
                pbRegister.visibility = View.VISIBLE
            }else{
                btnRegister.text = getString(R.string.txt_register)
                btnRegister.isEnabled = true
                pbRegister.visibility = View.GONE
            }
        }
    }

    private fun handleRegister(){
        val email = binding.etEmailRegister.text.toString()
        val password = binding.etPasswordRegister.text.toString()

        viewModel.register(email,password)
    }

}

fun Context.toast(message:String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}