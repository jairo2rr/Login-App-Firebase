package com.example.loginapp.domain.repository

import com.example.loginapp.util.Resource

interface AuthRepository {
    suspend fun login(email:String, password:String):Boolean

    suspend fun signUp(email:String, password:String):Boolean
}