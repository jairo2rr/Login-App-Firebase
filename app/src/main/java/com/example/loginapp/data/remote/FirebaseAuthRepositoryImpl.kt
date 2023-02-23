package com.example.loginapp.data.remote

import com.example.loginapp.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseAuthRepositoryImpl @Inject constructor(private val firebaseAuth: FirebaseAuth):AuthRepository {
    override suspend fun login(email: String, password: String): Boolean {
        return try {
            var isSuccessful = false
            firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnSuccessListener { isSuccessful = true }
                .addOnFailureListener{isSuccessful = false}
                .await()
            isSuccessful
        } catch (e:Exception){
            false
        }
    }

    override suspend fun signUp(email: String, password: String): Boolean {
        return try {
            var isSuccessful = false
            firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener { isSuccessful = true }
                .await()
            isSuccessful
        } catch (e:Exception){
            false
        }
    }
}