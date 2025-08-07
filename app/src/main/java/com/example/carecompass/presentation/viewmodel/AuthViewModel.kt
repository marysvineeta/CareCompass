package com.example.carecompass.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class AuthViewModel : ViewModel() {

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _authState = MutableStateFlow<String?>(null)
    val authState: StateFlow<String?> = _authState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                firebaseAuth.signInWithEmailAndPassword(email, password).await()
                _authState.value = "success"
            } catch (e: Exception) {
                _authState.value = e.message ?: "Login failed"
            }
        }
    }

    fun signUp(email: String, password: String) {
        viewModelScope.launch {
            try {
                firebaseAuth.createUserWithEmailAndPassword(email, password).await()
                _authState.value = "success"
            } catch (e: Exception) {
                _authState.value = e.message ?: "Signup failed"
            }
        }
    }

    fun logout() {
        firebaseAuth.signOut()
        _authState.value = null
    }
}
