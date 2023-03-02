package com.example.loginapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginapp.domain.usecase.FirebaseRegisterUseCase
import com.example.loginapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: FirebaseRegisterUseCase
):ViewModel() {
    private val _registerState = MutableLiveData<Resource<Boolean>>()
    val registerState:LiveData<Resource<Boolean>> = _registerState

    fun register(email:String,password:String){
        viewModelScope.launch {
            registerUseCase(email, password).onEach { state ->
                _registerState.value = state
            }.launchIn(viewModelScope)
        }
    }
}