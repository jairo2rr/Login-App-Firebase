package com.example.loginapp.di

import com.example.loginapp.data.remote.FirebaseAuthRepositoryImpl
import com.example.loginapp.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindAuthRepository(repositoryImpl: FirebaseAuthRepositoryImpl):AuthRepository
}