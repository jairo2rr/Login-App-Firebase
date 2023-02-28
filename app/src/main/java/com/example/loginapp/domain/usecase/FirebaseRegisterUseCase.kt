package com.example.loginapp.domain.usecase

import com.example.loginapp.domain.repository.AuthRepository
import com.example.loginapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FirebaseRegisterUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend operator fun invoke(email:String,password:String): Flow<Resource<Boolean>> = flow{
        emit(Resource.loading)
        val registerState = authRepository.signUp(email,password)
        if(registerState){
            emit(Resource.Success(true))
        }else{
            emit(Resource.Error("Register error"))
        }
    }
}