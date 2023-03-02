package com.example.loginapp.domain.usecase

import com.example.loginapp.domain.repository.AuthRepository
import com.example.loginapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FirebaseLoginUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend operator fun invoke(email:String,password:String):Flow<Resource<Boolean>> = flow{
        emit(Resource.loading)
        val loginState = authRepository.login(email,password)
        if(loginState){
            emit(Resource.Success(true))
            emit(Resource.finished)
        }else{
            emit(Resource.Error("Login error"))
            emit(Resource.finished)
        }
    }
}